package poo23.esercizio1;

public class Country implements Comparable<Country> {
	private String nome;
	private int superficie;

	public Country(String nome, int superficie) {
		this.nome = nome;
		this.superficie = superficie;
	}

	public String getNome() {
		return nome;
	}

	public int getSuperficie() {
		return superficie;
	}

	public int compareTo (Country other) {
		if(superficie > other.superficie)
			return -1;
		else
			return 1;
	}

}
