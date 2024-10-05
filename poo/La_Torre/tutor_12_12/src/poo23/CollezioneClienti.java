package poo23;

import java.util.ArrayList;
import java.util.List;

public class CollezioneClienti<T> {
	private List<Searchable<T>> clienti;

	public CollezioneClienti() {
		clienti = new ArrayList<>();
	}
	
	public void aggiungi(Searchable<T> c) {
		clienti.add(c);
	}
	
	public Searchable<T> cerca(T key) throws EmptyListException{
		if(clienti.isEmpty())
			throw new EmptyListException();
		for(Searchable<T> s : clienti)
			if(s.getKey().equals(key))
				return s;
		throw new ObjectNotFoundException();
	}
	
	public void rimuovi(T key) throws EmptyListException {
		if(clienti.isEmpty())
			throw new EmptyListException();
		
		for(Searchable<T> s : clienti)
			if(s.getKey().equals(key))
				clienti.remove(s);
	}

	public String toString() {
		return "CollezioneClienti [clienti=" + clienti + "]";
	}
	
	
}
