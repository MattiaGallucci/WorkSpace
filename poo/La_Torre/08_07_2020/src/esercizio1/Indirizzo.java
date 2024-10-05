package esercizio1;

public final class Indirizzo {
	private final String citta;
	private final int cap;
	private final String via;
	private final int numero;
	
	public Indirizzo(String citta, int cap, String via, int numero) {
		this.citta = citta;
		this.cap = cap;
		this.via = via;
		this.numero = numero;
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

	public int getNumero() {
		return numero;
	}
	
	
	
	
}
