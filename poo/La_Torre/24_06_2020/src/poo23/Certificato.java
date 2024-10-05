package poo23;

public final class Certificato {
	private int dataEmissione;
	private int dataScadenza;
	private String proprieta;
	private String emittente;

	public Certificato(int dataEmissione, int dataScadenza, String proprieta, String emittente) {
		this.dataEmissione = dataEmissione;
		this.dataScadenza = dataScadenza;
		this.proprieta = proprieta;
		this.emittente = emittente;
	}

	public String getProprieta() {
		return proprieta;
	}

	public String getEmittente() {
		return emittente;
	}

	public int getDataEmissione() {
		return dataEmissione;
	}

	public int getDataScadenza() {
		return dataScadenza;
	}

	public String toString() {
		return "Certificato [dataEmissione=" + dataEmissione + ", dataScadenza=" + dataScadenza + ", proprieta="
				+ proprieta + ", emittente=" + emittente + "]";
	}
	
	
}
