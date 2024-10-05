package poo23;

public class Cliente {
    private String cf;
    private String nome;
    private String cognome;
    private int numeroTelefono;
    
    public Cliente(String cf, String nome, String cognome, int numeroTelefono) {
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.numeroTelefono = numeroTelefono;
    }

    public String getCf() { return cf; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public int getNumeroTelefono() { return numeroTelefono; }

    

}
