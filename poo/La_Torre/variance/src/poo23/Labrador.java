package poo23;

public class Labrador extends Cane{

	public Labrador(String nome) {
		super(nome);
	}

	@Override
	public void verso() {
		System.out.println("BAU-BAU");
	}
}
