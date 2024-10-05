package esercizio1;

public class Indirizzo {
	private String citta;
	private int cap;
	private String via;
	private int numero;
	
	public Indirizzo(String citta, int cap, String via, int numero) {
		this.citta = citta;
		this.cap = cap;
		this.via = via;
		this.numero = numero;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
