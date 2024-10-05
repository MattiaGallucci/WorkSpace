package poo23;

public class Capi {
    private int id;
    private String modello;
    private String casaDiProduzione;
    private int quantitaInMgazzino;
    
    public Capi(int id, String modello, String casaDiProduzione, int quantitaInMgazzino) {
        this.id = id;
        this.modello = modello;
        this.casaDiProduzione = casaDiProduzione;
        this.quantitaInMgazzino = quantitaInMgazzino;
    }

    public int getId() { return id; }
    public String getModello() { return modello; }
    public String getCasaDiProduzione() { return casaDiProduzione; }
    public int getQuantitaInMgazzino() { return quantitaInMgazzino; }

    public void diminuisciQuantita() {
        quantitaInMgazzino--;
    }

    @Override
    public String toString() {
        return "Capi [id=" + id + ", modello=" + modello + ", casaDiProduzione=" + casaDiProduzione + ", quantitaInMgazzino=" + quantitaInMgazzino + "]";
    }
}
