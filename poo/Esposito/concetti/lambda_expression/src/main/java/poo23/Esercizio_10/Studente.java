package poo23.Esercizio_10;

import java.util.List;

public class Studente {
    private String nome;
    private String cognome;
    private List<Integer> voti;
    
    public Studente(String nome, String cognome, List<Integer> voti) {
        this.nome = nome;
        this.cognome = cognome;
        this.voti = voti;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
    public List<Integer> getVoti() { return voti; }

    @Override
    public String toString() {
        return "Studente [nome=" + nome + ", cognome=" + cognome + ", voti=" + voti + "]";
    }
    

}
