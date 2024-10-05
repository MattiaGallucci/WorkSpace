package poo23;

public class Studente {
    private String nome;
    private String cognome;
    private int matricola;
    private Voto voti;

    public Studente(String nome, String cognome, int matricola, Voto voti) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.voti = voti;
    }
    public Voto getVoti() {
        return voti;
    }

    public String toString() {
        return "Nome: " + nome + "\t\tCognome: " + cognome + "\t\tMatricola: " + matricola + "\t\tVoti: " + voti;
    }
}
