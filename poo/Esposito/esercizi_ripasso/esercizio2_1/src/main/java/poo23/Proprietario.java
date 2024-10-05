package poo23;

public class Proprietario {
    private String cf;
    private int numeroTelefonico;
    
    public Proprietario(String cf, int numeroTelefonico) {
        this.cf = cf;
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public int getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(int numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    @Override
    public String toString() {
        return "Proprietario [cf=" + cf + ", numeroTelefonico=" + numeroTelefonico + "]";
    }
    
}
