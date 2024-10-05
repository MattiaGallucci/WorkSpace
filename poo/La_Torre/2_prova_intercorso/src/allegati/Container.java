package allegati;

import java.util.ArrayList;

public class Container {

	
	private ArrayList<Prodotto> lista;
	private int capacitaMax;
	private int capacitaCaricata;
	
	public Container(int capacitaMax) {
		lista = new ArrayList<Prodotto>();
		this.capacitaMax = capacitaMax;
		capacitaCaricata = 0;
	}
	
	public ArrayList<Prodotto> select(int min,int max){
		ArrayList<Prodotto> tmp = new ArrayList<Prodotto>();
		for(Prodotto p : lista) {
			if(p.getPeso() <= max && p.getPeso() >= min)
				tmp.add(p);
		}
		return tmp;
	}
	
	public void add(Prodotto prodotto) {
		int index  = trova(prodotto);
		if(index < 0 && (capacitaCaricata + (prodotto.getPeso()) <= capacitaMax )) {
			lista.add(prodotto);
			capacitaCaricata += prodotto.getPeso();
		}
	}
	
	public Prodotto delete(Prodotto prodotto) {
		Prodotto p;
		int index = trova(prodotto);
		if(index >= 0) {
			p=lista.remove(index);
			capacitaCaricata -= p.getPeso();
			return p;
		}
		else return null;
	}
	
	
	private int trova(Prodotto p) {
		for(int i = 0; i < lista.size(); i++)
			if(lista.get(i).equals(p))
				return i;
		return -1;
	}
	
	public int getSize() {
		return lista.size();
	}
	
	public int getCapacitaMax() {
		return capacitaMax;
	}
	
	public int getCapacitaCaricata() {
		return capacitaCaricata;
	}
	
	
}
