package poo23;

public class Ordine {
    private String id;
    private Cliente cliente;
    private Prodotto prodottoOrdinato;
    private int quantita;
    
    public Ordine(String id, Cliente cliente, Prodotto prodottoOrdinati, int quantita) {
        this.id = id;
        this.cliente = cliente;
        this.prodottoOrdinato = prodottoOrdinati;
        this.quantita = quantita;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Prodotto getProdottoOrdinato() {
        return prodottoOrdinato;
    }

    public int getQuantita() {
        return quantita;
    }

    @Override
    public String toString() {
        return "Ordine [id=" + id + ", cliente=" + cliente + ", prodottoOrdinato=" + prodottoOrdinato + ", quantita="
                + quantita + "]";
    }


}
