package esercizio2;

import java.util.ArrayList;

public class Algoritmo {
	public <T> String estrai(ArrayList<T> list, Criterio<T> criterio) {
		String s = "";
		
		for(T item : list) {
			String informazione = criterio.usaCriterio(item);
			s = s + informazione + "\n";
		}
		
		return s;
	}
}
