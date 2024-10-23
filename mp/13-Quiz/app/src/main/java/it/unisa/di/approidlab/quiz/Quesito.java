package it.unisa.di.approidlab.quiz;

public class Quesito {
	private String testo;
	private boolean risposta;
	private boolean counted;
	
	public Quesito(String str, boolean risposta) {
		testo = str;
		this.risposta = risposta;
		counted = false;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String str) {
		testo = str;
	}

	public boolean getRisposta() {
		return risposta;
	}

	public void setRisposta(boolean risposta) {
		this.risposta = risposta;
	}
	
	public boolean hasBeenCounted() {
		return counted;
	}

	public void setCounted() {
		this.counted = true;
	}
	
}
