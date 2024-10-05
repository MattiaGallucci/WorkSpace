package esercizio1;

public class Velivolo {
	private String codice;
	private int pesoMassimo;
	private Certificato certificato;
	
	public Velivolo(String codice, int pesoMassimo, Certificato certificato) {
		this.codice = codice;
		this.pesoMassimo = pesoMassimo;
		this.certificato = certificato;
	}
	
}
