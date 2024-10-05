package esercizio1;

public abstract class Arredo implements Cloneable{
	private String descrizione;
	private Coppia<Integer> misura;
	
	public Arredo(String descrizione, Coppia<Integer> misura) {
		this.descrizione = descrizione;
		this.misura = misura;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public Coppia<Integer> getMisura() {
		return misura;
	}

	public String toString() {
		return getClass().getName() + " [descrizione=" + descrizione + ", misura=" + misura + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arredo other = (Arredo) obj;
		return descrizione.equals(other.descrizione) && misura.equals(other.misura);
	}
	
	public Arredo clone() {
		try {
			Arredo a = (Arredo) super.clone();
			a.misura = misura.clone();
			return a;
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
}
