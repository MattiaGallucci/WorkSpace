package poo23;

public enum TipologiaVeicolo {
    AUTO(1, 0.5),
    MOTO(2, 1.5),
    CAMION(3, 2.5);

    private int costoOra;
    private double costoFrazione;

    private TipologiaVeicolo(int costoOra, double costoFrazione){
        this.costoOra = costoOra;
        this.costoFrazione = costoFrazione;
    }
    
    public int getCostoOra() {
        return costoOra;
    }
    public double getCostoFrazione() {
        return costoFrazione;
    }

}
