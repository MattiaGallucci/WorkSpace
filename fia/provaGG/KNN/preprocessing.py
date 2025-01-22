import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Configurazione delle opzioni di visualizzazione per i DataFrame
pd.set_option('display.max_columns', None)

# Ignorare i warning per mantenere l'output pulito
import warnings
warnings.filterwarnings('ignore')

# Caricamento del dataset
df = pd.read_csv('matches.csv')

# Visualizzazione delle prime righe del dataset
print("Prime righe del dataset:")
print(df.head())

# Statistiche descrittive del dataset
print("\nStatistiche descrittive:")
print(df.describe())

# Informazioni generali sul dataset (tipi di dati, valori non nulli)
print("\nInformazioni sul dataset:")
print(df.info())

# Rimozione delle colonne non necessarie
df.drop(columns=["Unnamed: 0", "comp", "round", "attendance", "match report", "notes"], inplace=True)

# Conversione della colonna 'date' in formato datetime
df["date"] = pd.to_datetime(df["date"])

# Conversione di alcune colonne in tipo 'category' per ottimizzare la memoria
df['venue'] = df['venue'].astype('category')
df['opponent'] = df['opponent'].astype('category')
df['team'] = df['team'].astype('category')
df['result'] = df['result'].astype('category')

# Aggiunta di una colonna 'day' per il giorno della settimana
df['day'] = df['date'].dt.day_name()

# Estrazione dell'ora dalla colonna 'time'
df["hour"] = df["time"].str.replace(":.+", "", regex=True).astype("int")

# Aggiunta di una colonna 'day_code' per il giorno della settimana (0 = Lunedì, 6 = Domenica)
df["day_code"] = df["date"].dt.dayofweek

# Verifica dei duplicati nel dataset
print("\nNumero di duplicati nel dataset:", df.duplicated().sum())

#PULIAMO PRIMA DI STAMPARE
df.formation = df.formation.str.replace("◆", "")
df.formation = df.formation.str.replace("-0", "")

# Analisi delle formazioni più comuni
print("\nConteggio delle formazioni:")
print(df.formation.value_counts())

# Rimozione di caratteri speciali dalla colonna 'formation'
df.formation = df.formation.str.replace("◆", "")
df.formation = df.formation.str.replace("-0", "")

# Categorizzazione delle formazioni meno comuni come "Altro"
value_counts = df.formation.value_counts()
to_replace = value_counts[value_counts < 107].index
df['formation'] = df['formation'].replace(to_replace, 'Altro')

# Verifica delle formazioni dopo la pulizia
print("\nConteggio delle formazioni dopo la pulizia:")
print(df.formation.value_counts())

# Assegnazione dei punti in base al risultato (W = 3, D = 1, L = 0)
df['points'] = df['result'].apply(lambda x: 3 if x == 'W' else 1 if x == 'D' else 0)
df['points'] = df['points'].astype('int')

# Calcolo dei vincitori di ogni stagione
winners = df.groupby(['season', 'team'], observed=False)['points'].sum().reset_index() \
  .sort_values(['season', 'points'], ascending=[True, False]) \
  .groupby('season', observed=False).first()

# Aggiunta della colonna 'season_winner' per indicare il vincitore della stagione
df['season_winner'] = df['season'].map(winners['team'])

# Funzione per gestire i valori mancanti nella colonna 'captain'
def captains_func(data):
    if data['count'] == 0:
        data['count'] = np.nan
    return data

# Conteggio dei capitani per squadra
group = df.groupby('team', observed=False)['captain'].value_counts().reset_index(name='count')
group = group.apply(captains_func, axis=1)
group.dropna(inplace=True)
group = group.drop(columns='count')

# Esempio: Capitani del Liverpool
print("\nCapitani del Liverpool:")
print(group[group['team'] == 'Liverpool'])

# Conversione della colonna 'date' in formato datetime (se non già fatto)
df['date'] = pd.to_datetime(df['date'])

# Ordinamento del dataset per squadra e data
df_sorted = df.sort_values(['team', 'date'])

# Reset dell'indice per riflettere il nuovo ordine
df_sorted = df_sorted.reset_index(drop=True)

# Funzione per verificare l'ordinamento corretto
def verify_sorting(data):
    is_sorted = data.groupby('team', observed=False)['date'].is_monotonic_increasing.all()
    if is_sorted:
        print("Data is correctly sorted by date for each team.")
    else:
        print("WARNING: Data is not correctly sorted. Please check for inconsistencies.")

# Verifica dell'ordinamento
verify_sorting(df_sorted)

# Conversione delle colonne numeriche in tipo float
num_cols = ['sh', 'sot', 'dist', 'fk', 'pk', 'pkatt', 'xga', 'xg', 'gf', 'ga']
for col in num_cols:
    df_sorted[col] = pd.to_numeric(df_sorted[col])

# Funzione per calcolare le metriche avanzate
def calculate_fk_pk_ratios(data):
    data['fk_ratio'] = data['fk'] / data['sh']
    data['pk_conversion_rate'] = data['pk'] / data['pkatt']
    data['pk_per_shot'] = data['pkatt'] / data['sh']

    # Gestione dei valori infiniti
    data['fk_ratio'] = data['fk_ratio'].replace([np.inf, -np.inf], np.nan)
    data['pk_conversion_rate'] = data['pk_conversion_rate'].replace([np.inf, -np.inf], np.nan)
    data['pk_per_shot'] = data['pk_per_shot'].replace([np.inf, -np.inf], np.nan)

    # Conversione in percentuali
    data['fk_percentage'] = data['fk_ratio'] * 100
    data['pk_conversion_percentage'] = data['pk_conversion_rate'] * 100
    data['pk_per_shot_percentage'] = data['pk_per_shot'] * 100

    return data

# Applicazione della funzione
df_sorted = calculate_fk_pk_ratios(df_sorted)

# Rimozione delle colonne non necessarie
df_sorted.drop(['pk_conversion_rate', 'pk_conversion_percentage'], axis=1, inplace=True)

# Creazione di una figura con 4 subplot
fig, axs = plt.subplots(2, 2, figsize=(12, 6))
i = 0
for col in ['fk_ratio', 'pk_per_shot', 'fk_percentage', 'pk_per_shot_percentage']:
    sns.histplot(df_sorted[col], kde=True, ax=axs.flatten()[i])
    axs.flatten()[i].set_title('Distribuzione di ' + col)
    i += 1

plt.tight_layout()
plt.show()

# Boxplot per le stesse metriche
fig, axs = plt.subplots(2, 2, figsize=(12, 6))
i = 0
for col in ['fk_ratio', 'pk_per_shot', 'fk_percentage', 'pk_per_shot_percentage']:
    sns.boxplot(x=df_sorted[col], ax=axs.flatten()[i])
    axs.flatten()[i].set_title('Distribuzione di ' + col)
    i += 1

# Statistiche descrittive delle metriche
print("\nStatistiche delle metriche calcolate:")
print(df_sorted[['fk_ratio', 'pk_per_shot', 'fk_percentage', 'pk_per_shot_percentage']].agg(['mean', 'min', 'max']))

plt.tight_layout()
plt.show()

# Funzione per calcolare la media mobile
def calculate_rolling_average(data, column, window=5):
    return data.groupby('team', observed=False)[column].transform(
        lambda x: x.rolling(window=window, min_periods=1).mean()
    )

# Applicazione della funzione alle colonne selezionate
df_sorted['rolling_xg'] = calculate_rolling_average(df_sorted, 'xg')
df_sorted['rolling_xga'] = calculate_rolling_average(df_sorted, 'xga')
df_sorted['rolling_poss'] = calculate_rolling_average(df_sorted, 'poss')
df_sorted['rolling_sh'] = calculate_rolling_average(df_sorted, 'sh')
df_sorted['rolling_sot'] = calculate_rolling_average(df_sorted, 'sot')
df_sorted['rolling_dist'] = calculate_rolling_average(df_sorted, 'dist')

# Codifica del risultato in valori numerici (W = 1, D = 0, L = -1)
df_sorted['result_encoded'] = pd.to_numeric(df_sorted['result'].map({'W': 1, 'D': 0, 'L': -1}))

# Calcolo della forma (media mobile dei risultati)
df_sorted['form'] = calculate_rolling_average(df_sorted, 'result_encoded')

# Calcolo della differenza reti e della sua media mobile
df_sorted['goal_diff'] = df_sorted['gf'] - df_sorted['ga']
df_sorted['rolling_goal_diff'] = calculate_rolling_average(df_sorted, 'goal_diff')

# Funzione per calcolare il confronto diretto
def get_head_to_head(data):
    h2h = data.groupby(['team', 'opponent'], observed=False)['result_encoded'].mean().reset_index()
    h2h = h2h.rename(columns={'result_encoded': 'h2h_record'})
    result = pd.merge(data, h2h, on=['team', 'opponent'], how='left')
    return result

# Applicazione della funzione
df_sorted = get_head_to_head(df_sorted)

# Conversione della data in giorno della settimana (0 = Lunedì, 6 = Domenica)
df_sorted['day_of_week'] = pd.to_datetime(df_sorted['date']).dt.dayofweek

# Funzione per categorizzare l'orario delle partite
def categorize_time(time):
    hour = pd.to_datetime(time).hour
    if hour < 12:
        return 'early'
    elif hour < 17:
        return 'afternoon'
    else:
        return 'evening'

# Pulizia della colonna 'time' e applicazione della categorizzazione
df_sorted['time'] = df_sorted['time'].apply(lambda x: x.split(' ')[0])
df_sorted['time_condition'] = df_sorted['time'].apply(categorize_time)

# Conteggio delle partite per fascia oraria
print("\nConteggio delle partite per fascia oraria:")
print(df_sorted['time_condition'].value_counts())

# Calcolo dei giorni trascorsi dall'ultima partita
df_sorted['days_since_last_match'] = df_sorted.groupby('team', observed=False)['date'].diff().dt.days
df_sorted['days_since_last_match'] = df_sorted['days_since_last_match'].fillna(0)

# Rimozione delle colonne non necessarie
columns_to_drop = ['gf', 'ga', 'xg', 'xga', 'poss', 'sh', 'sot',
                   'goal_diff', 'day', 'pk', 'pkatt', 'fk',
                   'referee', 'dist','points', 'season_winner', 'hour', 'result_encoded', 'day_code']
df_sorted = df_sorted.drop(columns=columns_to_drop)

# Selezione delle colonne numeriche e categoriche
num_cols = df_sorted.select_dtypes(include=np.number).columns
num_cols = num_cols.drop(['season'])
num_cols = num_cols.tolist()
cat_cols = df_sorted.select_dtypes(exclude=np.number).columns
cat_cols = cat_cols.drop(['result', 'date'])
cat_cols = cat_cols.tolist()
predictors = num_cols + cat_cols

# Rimozione delle righe con valori mancanti
df_sorted.dropna(inplace=True)

# Pulizia dei nomi delle colonne
df_sorted.columns = df_sorted.columns.str.strip()
df_sorted = df_sorted[df_sorted.columns.tolist()[1:]]

# Categorizzazione della colonna 'time'
df_sorted['time'] = df_sorted['time'].astype('category')
value_counts = df_sorted.time.value_counts()
to_replace = value_counts[value_counts < 102].index
df_sorted['time'] = df_sorted['time'].replace(to_replace, 'Altro')

# Aggiornamento delle colonne categoriche e numeriche
cat_cols = df_sorted.select_dtypes(exclude=np.number).columns.tolist()
num_cols = df_sorted.select_dtypes(include=np.number).columns.tolist()
predictors = num_cols + cat_cols

# Salvataggio del dataset pre-processato
df_sorted.to_csv('matches_final.csv', index=False)