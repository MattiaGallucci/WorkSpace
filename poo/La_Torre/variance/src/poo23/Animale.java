package poo23;

public class Animale {
	private String nome;

	public Animale(String nome) {
		super();
		this.nome = nome;
	}
	
	public void verso() {
		System.out.println("?");
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [nome=" + nome + "]";
	}
	
	
	
	
	
}
