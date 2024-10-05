package esercizio1;

public final class Indirizzo implements Cloneable{
	private final String citta;
	private final int cap;
	private final String via;
	private final int civico;
	
	public Indirizzo(String citta, int cap, String via, int civico) {
		this.citta = citta;
		this.cap = cap;
		this.via = via;
		this.civico = civico;
	}

	public String getCitta() {
		return citta;
	}

	public int getCap() {
		return cap;
	}

	public String getVia() {
		return via;
	}

	public int getCivico() {
		return civico;
	}

	public String toString() {
		return getClass().getName() + " [citta=" + citta + ", cap=" + cap + ", via=" + via + ", civico=" + civico + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Indirizzo other = (Indirizzo) obj;
		return cap == other.cap && citta.equals(other.citta) && civico == other.civico
				&& via.equals(other.via);
	}
	
	public Indirizzo clone() {
		try {
			return (Indirizzo) super.clone();
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
}
