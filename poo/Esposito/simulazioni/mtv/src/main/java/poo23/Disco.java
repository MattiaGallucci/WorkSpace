package poo23;

public class Disco extends Arte {
    private String casaDiscografica;
    private int numeroCanzoni;
    
    public Disco(String titolo, String casaDiscografica, int anno, String artista, Genere genere, int numeroCanzoni) {
        super(titolo, anno, artista, genere);
        this.casaDiscografica = casaDiscografica;
        this.numeroCanzoni = numeroCanzoni;
    }

    public String getCasaDiscografica() {
        return casaDiscografica;
    }

    public void setCasaDiscografica(String casaDiscografica) {
        this.casaDiscografica = casaDiscografica;
    }

    public int getNumeroCanzoni() {
        return numeroCanzoni;
    }

    public void setNumeroCanzoni(int numeroCanzoni) {
        this.numeroCanzoni = numeroCanzoni;
    }

    @Override
    public String toString() {
        return super.toString() + "Disco [casaDiscografica=" + casaDiscografica + ", numeroCanzoni=" + numeroCanzoni + "]";
    }

    
}
