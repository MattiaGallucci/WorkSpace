package esercizio1;

public class Lavoratore {
	private String nome;
	private String cognome;
	private Indirizzo indirizzo;
	private double retribuzione;
	
	public Lavoratore(String nome, String cognome, Indirizzo indirizzo, double retribuzione) {
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.retribuzione = retribuzione;
	}
	
	public double getRetribuzione() {
		return retribuzione;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void paga(double importo) {
		retribuzione = importo;
	}
	
	
}
