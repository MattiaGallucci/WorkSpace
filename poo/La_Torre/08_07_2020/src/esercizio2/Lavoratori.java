package esercizio2;

import java.util.ArrayList;
import java.util.List;

import esercizio1.Lavoratore;

public class Lavoratori {
	private List<Lavoratore> lista;

	public Lavoratori() {
		lista = new ArrayList<>();
	}
	
	public void aggiungi(Lavoratore l) {
		lista.add(l);
	}
	
	public void calcolaPaga() {
		for(Lavoratore lavoratore : lista)
			lavoratore.paga(100);
	}
	
	public String paghe() {
		String tabella="";
		for(Lavoratore lavoratore : lista)
			tabella += lavoratore.getCognome() + " " + lavoratore.getRetribuzione() + "\n";
		return tabella;
	}
	
	
}
