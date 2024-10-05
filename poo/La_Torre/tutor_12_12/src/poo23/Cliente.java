package poo23;

public class Cliente implements Searchable<String>{
	private Indirizzo indirizzo;
	private String nome;
	
	public Cliente(Indirizzo indirizzo, String nome) {
		this.indirizzo = indirizzo;
		this.nome = nome;
	}

	public String getKey() {
		return nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Cliente other = (Cliente) obj;
		return indirizzo.equals(other.getIndirizzo()) && nome.equals(other.getNome());
	}
	
	public String toString() {
		return getClass().getSimpleName() + " [indirizzo=" + indirizzo + ", nome=" + nome + "]";
	}
	
}
