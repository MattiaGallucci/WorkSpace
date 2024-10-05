package poo23.tutor_28_11_1;

import java.io.Serializable;

public class Auto extends Veicolo implements Deteriorabile, Serializable{
	private int numeroPorte;
	private static
	final long serialVersionUID = 42L;

	public Auto(String targa, String modello, int kmPercorsi, int numeroPorte) {
		super(targa, modello, kmPercorsi);
		this.numeroPorte = numeroPorte;
	}

	public int getNumeroPorte() {
		return numeroPorte;
	}

	public double calcolaPedaggio() {
		return 0.10 * getKmPercorsi();
	}

	public double getStatoDeterioramento() {
		return numeroPorte * getKmPercorsi();
	}

	public String toString() {
		return super.toString() + "Auto [numeroPorte=" + numeroPorte + "]\n";
	}
}
