package poo23;

public class Prodotto {
    private String id;
    private String descrizione;
    private double prezzo;

    public Prodotto(String id, String descrizione, double prezzo){
        this.id = id;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    @Override
    public String toString() {
        return "Prodotto [id=" + id + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
    }
}
