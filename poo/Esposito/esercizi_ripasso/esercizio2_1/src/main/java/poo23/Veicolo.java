package poo23;

public class Veicolo {
    private TipologiaVeicolo tipo;
    private String targa;
    private Proprietario proprietario;
    
    public Veicolo(TipologiaVeicolo tipo, String targa, Proprietario proprietario) {
        this.tipo = tipo;
        this.targa = targa;
        this.proprietario = proprietario;
    }

    public TipologiaVeicolo getTipo() {
        return tipo;
    }

    public void setTipo(TipologiaVeicolo tipo) {
        this.tipo = tipo;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Veicolo [tipo=" + tipo + ", targa=" + targa + ", proprietario=" + proprietario + "]";
    }

    
}
