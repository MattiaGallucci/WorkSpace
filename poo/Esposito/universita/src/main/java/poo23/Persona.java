package poo23;

public class Persona {
    private String nome;
    private String cognome;

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return nome;}
    public void setCognome(String cognome) { this.cognome = cognome; }
    public String getCognome() { return cognome; }
    
    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String toString() {
        return "Nome: " + nome + "\tCognome: " + cognome;
    }
}