package poo23;

public class Moneta {
	private int valore;
	private int anno;
	
	public Moneta(int valore, int anno) {
		this.valore = valore;
		this.anno = anno;
	}

	public int getValore() {
		return valore;
	}

	public int getAnno() {
		return anno;
	}

	@Override
	public String toString() {
		return "Moneta [valore=" + valore + ", anno=" + anno + "]";
	}
	
	
}
