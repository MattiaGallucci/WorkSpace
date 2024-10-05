package esercizio1;

import java.util.ArrayList;

public class Algoritmo{
	public <T> ArrayList<T> applica(ArrayList<T> lista, Criterio<T> criterio){
		ArrayList<T> listaFiltrata = new ArrayList<T>();
		for(T item : lista) {
			if(criterio.seleziona(item))
				listaFiltrata.add(item);
		}
		return listaFiltrata;
	}
}
