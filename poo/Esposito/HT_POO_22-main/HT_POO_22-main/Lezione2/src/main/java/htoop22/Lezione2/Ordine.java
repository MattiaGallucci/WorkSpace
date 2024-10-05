package htoop22.Lezione2;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

	private static int cont_id = 1;
	private int id;
	private List<Prodotto> prodotti;
	private Cliente cliente;
	private tipoPagamento pagamento;
	private statoPagamento stato;

	public Ordine(int id, Cliente c, Prodotto...prodotti) {
		super();
		this.id = id;
		this.cliente = c;
		Optional.ofNullable(prodotti).ifPresentOrElse(p -> {
			this.prodotti = new ArrayList<>(Arrays.asList(prodotti));
		}, () -> {
			throw new IllegalArgumentException("Almeno un prodotto richiesto nell'ordine");
		});
		cont_id += 1;
		this.stato = stato.NON_PAGATO;
		this.pagamento = null;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Prodotto> getProdotti() {
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
	
	public <T extends Prodotto> void addProdottoToOrdine(T prodotto) {
		prodotti.add(prodotto);
	}
	

	public static <T extends Prodotto> Ordine makeOrdine(T p, int qta, Cliente c) throws Exception {
		if(p.getQta() >= qta) {
			T clone;
			try {
				clone = Prodotto.clone(p);
				p.setQta(p.getQta() - qta);
				clone.setQta(qta);
				Ordine o = new Ordine(cont_id, c, clone);
				return o;
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		} 
		throw new Exception("Non ci sono abbastanza disponibilità per il prodotto" + p.getNome());
	}
	
	
	public static Ordine makeOrdine(Cliente c1, List<? extends Prodotto> prodotti, List<Integer> qta) throws Exception {
		if(prodotti.size() != qta.size())
			throw new Exception("Liste non della stessa grandezza");
		
		Ordine o = null;
		Iterator<Integer> i = qta.iterator();
		for(Prodotto p : prodotti) {
			int q = i.next();
			if(p.getQta() >= q) {
				try {
					Prodotto clone = Prodotto.clone(p);
					p.setQta(p.getQta() - q);
					clone.setQta(q);
					if(o == null)
						o = new Ordine(cont_id,  c1, clone);
					else
						o.addProdottoToOrdine(clone);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException | NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			} 
			else
				throw new Exception("Non ci sono abbastanza disponibilità per il prodotto" + p.getNome());
		}
		return o;
	}
	
	

	@Override
	public String toString() {
		return "Ordine [id=" + id + ", totale ordine: " + this.getTotale() + "]";
	}




}
