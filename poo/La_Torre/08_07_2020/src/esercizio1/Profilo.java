package esercizio1;

public class Profilo implements Cloneable{
	private String descrizione;

	public Profilo(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Profilo clone() {
		try {
			return (Profilo) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Profilo other = (Profilo) obj;
		return descrizione.equals(other.getDescrizione());
	}

	public String toString() {
		return getClass().getSimpleName() + " [descrizione=" + descrizione + "]";
	}
	
	
	
}
