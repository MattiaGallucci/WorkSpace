package esercizio1;

public final class Letto extends Arredo implements Cloneable{
	private final TipologiaLetto specifica;

	public Letto(String descrizione, Coppia<Integer> misura, TipologiaLetto specifica) {
		super(descrizione, misura);
		this.specifica = specifica;
	}

	public TipologiaLetto getSpecifica() {
		return specifica;
	}

	public String toString() {
		return super.toString() + " [specifica=" + specifica + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letto other = (Letto) obj;
		return specifica == other.specifica;
	}
	
	public Letto clone() {
		return (Letto) super.clone();
	}
	
}
