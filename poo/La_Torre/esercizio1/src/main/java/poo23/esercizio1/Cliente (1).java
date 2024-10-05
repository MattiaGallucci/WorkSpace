package poo23.esercizio1;

public class Cliente implements Comparable<Cliente>{
	private String nome;
	private int eta;

	public Cliente(String nome, int eta) {
		this.nome = nome;
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public int getEta() {
		return eta;
	}
	
	public int compareTo(Cliente other) {
		if(eta > other.eta)
			return -1;
		else if(eta < other.eta)
			return 1;
		else
			return nome.compareToIgnoreCase(other.nome);
	}
	

}
