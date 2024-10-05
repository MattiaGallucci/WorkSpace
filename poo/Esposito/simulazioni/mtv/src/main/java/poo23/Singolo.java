package poo23;

public class Singolo extends Arte {
    private Disco disco;
    
    public Singolo(String titolo, int anno, String artista, Genere genere, Disco disco) {
        super(titolo, anno, artista, genere);
        this.disco = disco;
        try{
            if( !(genere.equals(disco.getGenere())) )
                throw new GenereMismatchException("Il genere non corrisponde");
            if ( !(anno == disco.getAnno()) )
                throw new AnnoMismatchException("L'anno non corrisponde");
        } catch (GenereMismatchException | AnnoMismatchException e){
            System.err.println(e.getMessage());
        }
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return super.toString() + "Singolo [disco=" + disco + "]";
    }


}
