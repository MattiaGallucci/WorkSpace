package poo23.tutor_28_11_1;

public class Veicolo {
	

	private String targa;
	private String modello;
	private int kmPercorsi;

	public Veicolo(String targa, String modello, int kmPercorsi) {
		this.targa = targa;
		this.modello = modello;
		this.kmPercorsi = kmPercorsi;
	}

	public String getTarga() {
		return targa;
	}

	public String getModello() {
		return modello;
	}

	public int getKmPercorsi() {
		return kmPercorsi;
	}

	public String toString() {
		return "\tVeicolo [targa=" + targa + ", modello=" + modello + ", kmPercorsi=" + kmPercorsi + "]";
	}
}
