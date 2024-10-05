package poo23.tutor_21_11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Libreria implements Serializable{
	private static final long serialVersionUID = 42L;
	private List<Libro> libreria;

	public Libreria() {
		libreria = new ArrayList<>();
	}

	public void aggiungiLibro(Libro libro) throws LibroDuplicatoException { // se l'eccezione è controllata devi aggiungere throws
		if(libreria.contains(libro))
			throw new LibroDuplicatoException();
		libreria.add(libro);
	}

	@Override
	public String toString() {
		return "Libreria [libreria=" + libreria + "]";
	}

}
