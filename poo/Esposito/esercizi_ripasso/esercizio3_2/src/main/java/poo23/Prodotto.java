package poo23;

public class Prodotto {
    private TipologiaProdotto tipologia;
    private String nome;
    private int quantita;
    
    public Prodotto(TipologiaProdotto tipologia, String nome, int quantita) {
        this.tipologia = tipologia;
        this.nome = nome;
        this.quantita = quantita;
    }

    public TipologiaProdotto getTipologia() {
        return tipologia;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }


}
