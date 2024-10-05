package esercizio1;

public final class Certificato {
	private final String data;
	private final String descrizione;
	
	public Certificato(String data, String descrizione) {
		this.data = data;
		this.descrizione = descrizione;
	}

	public String getData() {
		return data;
	}

	public String getDescrizione() {
		return descrizione;
	}
	
}
