package poo23;

public class Persona {
    private String nome;
    private String cognome;
    private String cf;
    private int eta;
    private TipologiaVaccino vaccino;
    private String dataPrimaDose;
    private String dataSecondaaDose;
    
    public Persona(String nome, String cognome, String cf, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.eta = eta;
    }

    public int getEta() {
        return eta;
    }

    public TipologiaVaccino getVaccino() {
        return vaccino;
    }

    public void setVaccino(TipologiaVaccino vaccino) {
        this.vaccino = vaccino;
    }

    public String getDataPrimaDose() {
        return dataPrimaDose;
    }

    public void setDataPrimaDose(String dataPrimaDose) {
        this.dataPrimaDose = dataPrimaDose;
    }

    public String getDataSecondaaDose() {
        return dataSecondaaDose;
    }

    public void setDataSecondaaDose(String dataSecondaaDose) {
        this.dataSecondaaDose = dataSecondaaDose;
    }

    public void iniettaPrimaDose(Persona p, TipologiaVaccino t, String data) throws AgeLessThanException{

        if(p.getEta() >= 18 && !(t.equals(TipologiaVaccino.PFIZER))){
            p.setDataPrimaDose(data);
            if(!(t.equals(TipologiaVaccino.JANDJ)))
                p.setDataSecondaaDose("11");
        
        }
    }

    @Override
    public String toString() {
        return "Persona [nome=" + nome + ", cognome=" + cognome + ", cf=" + cf + ", eta=" + eta + ", vaccino=" + vaccino
                + ", dataPrimaDose=" + dataPrimaDose + ", dataSecondaaDose=" + dataSecondaaDose + "]";
    }


}
