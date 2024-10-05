package poo23;

public class Proprietario {
	private String nome;
	private String indirizzo;
	
	public Proprietario(String nome, String indirizzo) {
		this.nome = nome;
		this.indirizzo = indirizzo;
	}
	
	public void modificaIndirizzo(String nuovoIndirizzo) {
		indirizzo = nuovoIndirizzo;
	}

	public String toString() {
		return "Proprietario [nome=" + nome + ", indirizzo=" + indirizzo + "]";
	}
	
	
}
