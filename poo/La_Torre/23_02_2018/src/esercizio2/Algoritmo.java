package esercizio2;

import java.util.ArrayList;

public class Algoritmo {
	public <T> ArrayList<T> ordina(ArrayList<T> lista, Criterio<T> criterio){
		int n = lista.size();
		boolean scambio;
		
		do {
            scambio = false;
            for (int i = 0; i < n - 1; i++) {
                if (criterio.useCriterio(lista.get(i), lista.get(i + 1)) > 0) {
                	T temp = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, temp);
                    scambio = true;
                }
            }
            n--;
        } while (scambio);
		return lista;
	}
}
