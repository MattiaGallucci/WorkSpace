package it.unisa.voli;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Cielo {
	private Set<Volo> voli;

	public Cielo() {
		super();
		voli = new HashSet<>();
	}
	
	public void insertVolo(Volo volo) throws Errore {
		if(!voli.add(volo))
			throw new Errore("Mancato inserimento");
	}
	
	public Volo returnVolo(String ID) throws Errore {
		Volo volo = null;
		if(voli.size() != 0) {
			Iterator<Volo> iterator = voli.iterator();
			while(iterator.hasNext()) {
				Volo elem = iterator.next();
				if(elem.getID().equals(ID)) {
					volo = elem;
					break;
				}
			}
		}
		
		if(volo == null)
			throw new Errore("Mancato ritorno");
		
		return volo;
	}
	
	public Set<Volo> returnVoliOrigine(String origine) throws Errore {
		Set<Volo> voli_2_be_returned = new HashSet<>();
		if(voli.size() != 0) {
			Iterator<Volo> iterator = voli.iterator();
			while(iterator.hasNext()) {
				Volo elem = iterator.next();
				if(elem.getOrigine().equals(origine)) {
					voli_2_be_returned.add(elem);
				}
			}
		}
		
		if(voli_2_be_returned.size() == 0)
			throw new Errore("Mancato ritorno");
		
		return voli_2_be_returned;
	}
}
