package oop22;

public class Pesca extends Frutta {

	public Pesca(double peso) {
		super(peso);
	}

	@Override
	public String toString() {
		return "Pesca [peso=" + peso + "]";
	}
}