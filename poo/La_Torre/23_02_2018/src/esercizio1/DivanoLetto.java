package esercizio1;

public class DivanoLetto extends Arredo{
	private int posti;
	private boolean letto;
	Coppia<Integer> grandezzaLetto;
	
	public DivanoLetto(String descrizione, Coppia<Integer> misura, int posti, boolean letto,
			Coppia<Integer> grandezzaLetto) {
		super(descrizione, misura);
		this.posti = posti;
		this.letto = letto;
		this.grandezzaLetto = grandezzaLetto;
	}

	public String toString() {
		return super.toString() + " [posti=" + posti + ", letto=" + letto + ", grandezzaLetto=" + grandezzaLetto + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DivanoLetto other = (DivanoLetto) obj;
		return grandezzaLetto.equals(other.grandezzaLetto) && letto == other.letto && posti == other.posti;
	}
	
	public DivanoLetto clone() {
		return (DivanoLetto) super.clone();
	}
	
}
