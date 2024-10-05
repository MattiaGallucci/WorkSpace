package poo23;

public class Cliente {
    String nome;
    String cognome;
    String citta;
    
    public Cliente(String nome, String cognome, String citta) {
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", cognome=" + cognome + ", citta=" + citta + "]";
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCitta() {
        return citta;
    }

    


}
