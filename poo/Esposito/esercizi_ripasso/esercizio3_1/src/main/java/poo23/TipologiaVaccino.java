package poo23;

public enum TipologiaVaccino {
    ASTRAZENECA("Virale",18),
    JANDJ("Virale", 18),
    PFIZER("mRNA", 16),
    MODERNA("mRNA", 18);

    private String vettore;
    private int etaMinima;

    private TipologiaVaccino(String vettore, int etaMinima) {
        this.vettore = vettore;
        this.etaMinima = etaMinima;
    }

    public String getVettore() {
        return vettore;
    }

    public int getEtaMinima() {
        return etaMinima;
    }
    
}
