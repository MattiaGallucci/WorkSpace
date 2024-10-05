package esercizio1;

public class Cliente implements Searchable<String>, Cloneable{
	private String nome;
	private Indirizzo indirizzo;
	
	public Cliente(String nome, Indirizzo indirizzo) {
		this.nome = nome;
		this.indirizzo = indirizzo;
	}

	public String getKey() {
		return nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String toString() {
		return getClass().getName() + " [nome=" + nome + ", indirizzo=" + indirizzo + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return indirizzo.equals(other.indirizzo) && nome.equals(other.nome);
	}
	
	public Cliente clone() {
		try {
			Cliente c = (Cliente) super.clone();
			c.indirizzo = indirizzo.clone();
			return c;
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
}
