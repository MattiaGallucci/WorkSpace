package poo23;

public class Arte {
    public String titolo;
    public int anno;
    public String artista;
    public Genere genere;
    
    public Arte(String titolo, int anno, String artista, Genere genere) {
        this.titolo = titolo;
        this.anno = anno;
        this.artista = artista;
        this.genere = genere;
    }
    
    public String getTitolo() {
        return titolo;
    }
    public int getAnno() {
        return anno;
    }
    public String getArtista() {
        return artista;
    }
    public Genere getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Arte [titolo=" + titolo + ", anno=" + anno + ", artista=" + artista + ", genere=" + genere + "]";
    }

    
}
