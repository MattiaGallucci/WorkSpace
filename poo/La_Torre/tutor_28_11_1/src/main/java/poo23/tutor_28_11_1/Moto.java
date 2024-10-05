package poo23.tutor_28_11_1;

import java.io.Serializable;

public class Moto extends Veicolo implements Deteriorabile, Serializable {
	private int cilindrata;
	private static
	final long serialVersionUID = 42L;

	public Moto(String targa, String modello, int kmPercorsi, int cilindrata) {
		super(targa, modello, kmPercorsi);
		this.cilindrata = cilindrata;
	}

	public String getTarga() {
		return getTarga();
	}

	public double calcolaPedaggio() {
		return 0.08 * getKmPercorsi();
	}

	public double getStatoDeterioramento() {
		return 2 * getKmPercorsi();
	}

	public String toString() {
		return super.toString() +  "Moto [cilindrata=" + cilindrata + "]";
	}
}
