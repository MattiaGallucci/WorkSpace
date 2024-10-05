package htoop22.Lezione1;

import java.util.ArrayList;
import java.util.Iterator;

public class Ordine {
	
	public enum tipoPagamento {
		PAYPAL,
		CONTRASSEGNO,
		BONIFICO
	}
	
	public enum statoPagamento {
		PAGATO,
		NON_PAGATO
	}
	
	private int id;
	private ArrayList<Prodotto> prodotti;
	private tipoPagamento pagamento;
	private statoPagamento stato; 
	
	public Ordine(int id) {
		super();
		this.id = id;
		this.prodotti = new ArrayList<Prodotto>();
		this.stato = stato.NON_PAGATO;
		this.pagamento = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Prodotto> getProdotti() {
		return prodotti;
	}
	public void setProdotti(ArrayList<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	public tipoPagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(tipoPagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public statoPagamento getStato() {
		return stato;
	}
	public void setStato(statoPagamento stato) {
		this.stato = stato;
	}
	
	public double getTotale() {
		Iterator<Prodotto> i = this.prodotti.iterator();
		double total = 0;
		while (i.hasNext()) {
			Prodotto p = i.next();
			total += p.getPrezzo() * p.getQta();
		}
		return total;
	}
	
	public void addProdottoToOrdine(Prodotto p) {
		this.getProdotti().add(p);
	}
	@Override
	public String toString() {
		return "Ordine [id=" + id + ", totale ordine: " + this.getTotale() + "]";
	}
	
	
	

}
