package poo23.eccezioni;

public class Divisione {
	private int num;
	private int den;

	public Divisione(int n, int d) {
		num = n;
		den = d;
	}

	public double dividi() {
		if (den == 0)
			throw new DivisionePerZeroException("DIVISIONE PER ====0");
		return num / den;
	}

}
