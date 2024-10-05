package poo23;

public final class Indirizzo {
	private final String citta;
	private final int cap;
	private final String via;
	private final int numeroCivico;
	
	public Indirizzo(String citta, int cap, String via, int numeroCivico) {
		this.citta = citta;
		this.cap = cap;
		this.via = via;
		this.numeroCivico = numeroCivico;
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
	
	public int getNumeroCivico() {
		return numeroCivico;
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Indirizzo other = (Indirizzo) obj;
		return citta.equals(other.getCitta()) && cap == other.getCap() && via.equals(other.getVia()) && numeroCivico == other.getNumeroCivico();
	}

	public String toString() {
		return getClass().getSimpleName() + " [citta=" + citta + ", cap=" + cap + ", via=" + via + ", numeroCivico=" + numeroCivico + "]";
	}
}
