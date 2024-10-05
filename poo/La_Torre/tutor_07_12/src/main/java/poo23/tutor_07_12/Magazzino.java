package poo23.tutor_07_12;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Magazzino implements Serializable{
	private ArrayList<Prodotto> magazzino;

	public Magazzino() {
		magazzino = new ArrayList<>();
	}
	
	public void aggiungiProdotto(Prodotto prodotto) throws ItemAlreadyPresentException{
			if(magazzino.contains(prodotto))
				throw new ItemAlreadyPresentException();
			magazzino.add(prodotto);
	}
	
	public void rimuoviProdotto(Prodotto prodotto) {
		if(!(magazzino.contains(prodotto)))
			throw new ItemNotFoundException();
		magazzino.remove(prodotto);
	}
	
	public Prodotto trovaProdotto(Prodotto prodotto) {
		if(!(magazzino.contains(prodotto)))
			throw new ItemNotFoundException();
		
		Prodotto found = null;
		
		for(Prodotto p : magazzino)
			if(prodotto.equals(p))
				found = p;
		
		return found;
	}

	public ArrayList<Prodotto> getProdotti() {
		return magazzino;
	}
	
}
