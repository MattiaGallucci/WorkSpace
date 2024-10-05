package poo23;

public class Scarpe extends Capi{
    private int taglia;
    private final int costo = 50;

    public Scarpe(int id, String modello, String casaDiProduzione, int quantitaInMgazzino, int taglia) {
        super(id, modello, casaDiProduzione, quantitaInMgazzino);
        this.taglia = taglia;
    }

    public int getTaglia() { return taglia; }
    public int getCosto() { return costo; }

    
}
