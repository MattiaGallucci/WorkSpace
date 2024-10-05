package poo23.tutor_21_11;

import java.io.Serializable;

public class Libro implements Serializable{
	private static final long serialVersionUID = 42L;
	private String titolo, autore;
	private int annoPubblicazione;

	public Libro(String titolo, String autore, int annoPubblicazione) {
		this.titolo = titolo;
		this.autore = autore;
		this.annoPubblicazione = annoPubblicazione;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getAutore() {
		return autore;
	}

	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return libro.getTitolo().equals(titolo) && libro.getAutore().equals(autore) && libro.getAnnoPubblicazione()== annoPubblicazione;
    }

}
