package esercizio2;

import java.util.ArrayList;

public class Algoritmo {
	public <T> ArrayList<T> estrai(ArrayList<T> list, Criterio<T> criterio) {
		ArrayList<T> listaFiltrata = new ArrayList<>();
		for(T item : list) {
			if(criterio.usaCriterio(item))
				listaFiltrata.add(item);
		}
		return listaFiltrata;
	}
}