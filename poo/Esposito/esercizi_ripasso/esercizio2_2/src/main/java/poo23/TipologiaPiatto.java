package poo23;

public enum TipologiaPiatto {
    ANTIPASTO(5),
    PRIMO(10),
    SECONDO(13);

    private int costo;

    private TipologiaPiatto(int costo){
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    
}
