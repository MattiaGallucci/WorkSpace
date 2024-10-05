package esercizio1;

public class Appartamento extends Immobile implements Cloneable {
	private int piano;
	private int stanze;
	private Certificato certificato;

	public Appartamento(Indirizzo indirizzo, String descrizione, int prezzo, int piano, int stanze,
			Certificato certificato) {
		super(indirizzo, descrizione, prezzo);
		this.piano = piano;
		this.stanze = stanze;
		this.certificato = certificato;
	}

	public int getPiano() {
		return piano;
	}

	public void setPiano(int piano) {
		this.piano = piano;
	}

	public int getStanze() {
		return stanze;
	}

	public void setStanze(int stanze) {
		this.stanze = stanze;
	}

	public Certificato getCertificato() {
		return certificato;
	}

	public void setCertificato(Certificato certificato) {
		this.certificato = certificato;
	}

	public String getDescrizione() {
		return super.getDescrizione() + certificato.getCategoria();
	}

	public String toString() {
		return getClass().getName() + " [piano=" + piano + ", stanze=" + stanze + ", certificato=" + certificato + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Appartamento other = (Appartamento) obj;
		return certificato.equals(other.certificato) && piano == other.piano && stanze == other.stanze;
	}

	public Appartamento clone() {
		try {
			return (Appartamento) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
