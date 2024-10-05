package poo23;

public class Gatto extends Animale{

	public Gatto(String nome) {
		super(nome);
	}
	
	@Override
	public void verso() {
		System.out.println("MIAO");
	}
	
}
