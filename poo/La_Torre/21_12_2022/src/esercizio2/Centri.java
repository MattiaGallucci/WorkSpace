package esercizio2;

import java.util.ArrayList;

import esercizio1.CentroUrbano;

public class Centri<T extends CentroUrbano> {
	private ArrayList<T> centri;

	public Centri() {
		centri = new ArrayList<>();
	}

	public void aggiungi(T x) throws MissingPositionException {
		if (x instanceof CentroUrbanoMappa) {
			int i = cerca(x.getNome());
			if (i == -1)
				centri.add(x);
		} else
			throw new MissingItemException();

	}

	private int cerca(String unNome) {
		int i;
		for (i = 0; i < centri.size(); i++)
			if (centri.get(i).getNome().equalsIgnoreCase(unNome))
				return i;
		return -1;
	}

	public void cancella(String unNome) {
		int i = cerca(unNome);
		if (i != -1) {
			centri.remove(i);
		} else
			throw new MissingItemException();
	}

	public T getCentro(String unNome) {
		int i = cerca(unNome);
		if (i != -1) {
			T found = centri.get(i);
			return (T) found.clone();
		}
		return null;
	}

	public int getAbitantiCentro(String unNome) {
		int i = cerca(unNome);
		if (i != -1) {
			return centri.get(i).getAbitanti();
		}
		return -1;
	}

	public Centri<T> clone() {
		try {
			Centri<T> c = (Centri<T>) super.clone();
			c.centri = (ArrayList<T>) centri.clone();
			for (T elem : c.centri) {
				elem = (T) super.clone();
			}
			return c;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public int getSize() {
		return centri.size();
	}

}
