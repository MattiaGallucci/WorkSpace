package esercizio1;

public class Immobile {
	private Indirizzo indirizzo;
	private String descrizione;
	private int prezzo;
	
	public Immobile(Indirizzo indirizzo, String descrizione, int prezzo) {
		this.indirizzo = indirizzo;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	
}
