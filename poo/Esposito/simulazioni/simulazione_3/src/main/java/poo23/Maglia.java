package poo23;

public class Maglia extends Capi {
    private String taglia;
    private final int costo = 25;

    public Maglia(int id, String modello, String casaDiProduzione, int quantitaInMgazzino, String taglia) {
        super(id, modello, casaDiProduzione, quantitaInMgazzino);
        this.taglia = taglia;
    }

   public String getTaglia() { return taglia; }
   public int getCosto() { return costo; }

    @Override
    public String toString() {
        return super.toString() + "Maglia [taglia=" + taglia + ", costo=" + costo + "]";
    }


    
}
