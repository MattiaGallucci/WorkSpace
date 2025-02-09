package com.example.esempio4;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tentativi, indovina;
    EditText et;

    int count = 0;

    String[] parole = {"AUTOSTRADA", "MATTIA", "CHICCA", "CASA", "GATTO", "LIBRO", "SOLE", "LUNA", "ALBERO", "FIUME", "MARE", "MONTAGNA", "CITTA", "PAESE", "AMICO", "FAMIGLIA", "SCUOLA", "LAVORO", "TEMPO", "GIOCO", "SPORT", "MUSICA", "ARTE", "CIBO", "VIAGGIO", "NATURA", "SCIENZA", "TECNOLOGIA", "INFORMAZIONE", "COMUNICAZIONE", "EMOZIONE", "PENSIERO", "SOGNO", "REALTA", "FUTURO", "PASSATO", "PRESENTE", "VITA", "MORTE", "AMORE", "ODIO", "GIOIA", "TRISTEZZA", "RABBIA", "PAURA", "CORAGGIO", "SPERANZA", "FEDE", "VERITA", "BELLEZZA", "SAGGEZZA", "CONOSCENZA", "POTERE", "RESPONSABILITA", "LIBERTA", "GIUSTIZIA", "PACE", "GUERRA", "SUCCESSO", "FALLIMENTO", "OPPORTUNITA", "SFIDA", "CAMBIAMENTO", "CRESCITA", "APPRENDIMENTO", "INNOVAZIONE", "SCOPERTA", "AVVENTURA", "CURIOSITA", "ENTUSIASMO", "PASSIONE", "DETERMINAZIONE", "PERSEVERANZA", "IMPEGNO", "SACRIFICIO", "SUSTENTABILITA", "DIVERSITA", "INCLUSIONE", "RISPETTO", "TOLLERANZA", "UMANITA"};
    String parola;
    StringBuilder parolaUtente; // Usiamo StringBuilder per gestire le modifiche

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tentativi = findViewById(R.id.tentativi);
        indovina = findViewById(R.id.indovina);
        et = findViewById(R.id.et);

        // Scegli una parola casuale
        parola = parole[(int) (Math.random() * parole.length)];

        // Inizializza parolaUtente con underscore
        parolaUtente = new StringBuilder();
        for (int i = 0; i < parola.length(); i++) {
            parolaUtente.append('_');
        }

        // Mostra la parola con gli underscore
        indovina.setText(scrivi(parolaUtente.toString()));
    }

    public void prova(View view) {
        if (et.getText().length() > 0) {
            char c = et.getText().charAt(0);
            count++;
            tentativi.setText("Tentativi: " + count);

            // Verifica se la lettera è presente nella parola
            boolean trovata = false;
            for (int i = 0; i < parola.length(); i++) {
                if (parola.charAt(i) == c) {
                    parolaUtente.setCharAt(i, c); // Sostituisci l'underscore con la lettera corretta
                    trovata = true;
                }
            }

            // Aggiorna la visualizzazione
            indovina.setText(scrivi(parolaUtente.toString()));

            // Pulisci l'EditText
            et.setText("");

            // Controlla se l'utente ha indovinato l'intera parola
            if (parolaUtente.toString().equals(parola)) {
                indovina.setText("Hai vinto! La parola era: " + parola);
            }

            // Messaggio di feedback
            if (!trovata) {
                tentativi.append("\nLettera non trovata!");
            }
        }
    }

    // Metodo per formattare la parola con spazi tra i caratteri
    public String scrivi(String parola) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < parola.length(); i++) {
            str.append(parola.charAt(i));
            str.append(" ");
        }
        return str.toString();
    }

    public void reset(View view) {
        // Ripristina il conteggio dei tentativi
        count = 0;
        tentativi.setText("Tentativi: " + count);

        parola = parole[(int) (Math.random() * parole.length)];

        // Inizializza parolaUtente con underscore
        parolaUtente = new StringBuilder();
        for (int i = 0; i < parola.length(); i++) {
            parolaUtente.append('_');
        }

        // Mostra la parola con gli underscore
        indovina.setText(scrivi(parolaUtente.toString()));
    }
}