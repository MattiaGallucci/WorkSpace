package esercizio1;

import java.util.ArrayList;

import allegati.Prodotto;

public class Container <T extends Prodotto>{

	private ArrayList<T> lista;
	private int capacitaMax;
	private int capacitaCaricata;
	
	public Container(int capacitaMax) {
		lista = new ArrayList<T>();
		this.capacitaMax = capacitaMax;
		capacitaCaricata = 0;
	}
	
	public ArrayList<T> select(Criterio<T> criterio){
		ArrayList<T> tmp = new ArrayList<T>();
		for(T p : lista) {
			if(criterio.useCriterio(p))
				tmp.add(p);
		}
		return tmp;
	}
	
	public void add(T prodotto) throws FullContainerException{
		if(prodotto.getPeso() + capacitaCaricata > capacitaMax)
			throw new FullContainerException("Il prodotto fa superare la capacità massima");
		
		int index = trova(prodotto);
		if(index < 0 && (capacitaCaricata + (prodotto.getPeso()) <= capacitaMax )) {
			lista.add(prodotto);
			capacitaCaricata += prodotto.getPeso();
		}
	}
	
	public T delete(T prodotto) {
		T p;
		int index = trova(prodotto);
		
		if(!(lista.contains(prodotto)))
			throw new ItemNotFoundException("Prodotto non trovato");
		
		if(index >= 0) {
			p=lista.remove(index);
			capacitaCaricata -= p.getPeso();
			return p;
		}
		else return null;
	}
	
	
	private int trova(T p) {
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
	
	public ArrayList<T> getLista() {
		return lista;
	}
	
}
