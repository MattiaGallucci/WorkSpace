package poo23;

public class RottaAerea {
    private String origine;
    private String destinazione;
    private String codice;
    private Coordinate posizione;

    public RottaAerea(String origine, String destinazione, String codice, Coordinate posizione) {
        this.origine = origine;
        this.destinazione = destinazione;
        this.codice = codice;
        this.posizione = posizione;
    }

    @Override
    public String toString() {
        return "RottaAerea [origine=" + origine + ", destinazione=" + destinazione + ", codice=" + codice
                + ", posizione=" + posizione + "]";
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public Coordinate getPosizione() {
        return posizione;
    }

    public void setPosizione(Coordinate posizione) {
        this.posizione = posizione;
    }

    
}
