package esercizio2;

import java.util.ArrayList;

import esercizio1.Searchable;

public class KeyList<T> {
	private ArrayList<Searchable<T>> list;

	public KeyList() {
		list = new ArrayList<>();
	}

	public void aggiungi(Searchable<T> item) {
		list.add(item);
	}

	public Searchable<T> cerca(T key) throws EmptyListException {
		if (list.isEmpty())
			throw new EmptyListException();
		for (Searchable<T> item : list) {
			if (item.getKey().equals(key))
				return item;
		}
		throw new ObjectNotFoundException();
	}

	public void rimuovi(T key) throws EmptyListException {
		if (list.isEmpty())
			throw new EmptyListException("MANNAGGIA");
		for (Searchable<T> item : list) {
			if (item.getKey().equals(key))
				list.remove(item);
		}
	}

	public String toString() {
		return "KeyList [list=" + list + "]";
	}
	
	
}
