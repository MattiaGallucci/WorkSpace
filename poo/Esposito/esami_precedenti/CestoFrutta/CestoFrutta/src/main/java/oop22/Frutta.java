package oop22;

public abstract class Frutta implements Comparable <Frutta>{
	protected double peso;

	public double getPeso() {
		return peso;
	}

	public Frutta(double peso) {
		super();
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Frutta [peso=" + peso + "]";
	}

	public int compareTo(Frutta o) {
		return (int) (this.peso - o.peso);
	}
}
