package it.unisa.scuola;

public class Persona {
	private final String CF;
	private final String nome;
	private final String cognome;
			
	public String getCF() {
		return CF;
	}


	public String getNome() {
		return nome;
	}


	public String getCognome() {
		return cognome;
	}


	public Persona(String cF, String nome, String cognome) {
		super();
		CF = cF;
		this.nome = nome;
		this.cognome = cognome;
	}


	@Override
	public String toString() {
		return "Persona [CF=" + CF + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
}
