package esercizio1;

public class CartaBonus implements Cloneable{
	private int sconto;
	private int scadenza;
	
	public CartaBonus(int sconto, int scadenza) {
		this.sconto = sconto;
		this.scadenza = scadenza;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public int getScadenza() {
		return scadenza;
	}

	public void setScadenza(int scadenza) {
		this.scadenza = scadenza;
	}

	public String toString() {
		return getClass().getName() + " [sconto=" + sconto + ", scadenza=" + scadenza + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaBonus other = (CartaBonus) obj;
		return scadenza == other.scadenza && sconto == other.sconto;
	}
	
	public CartaBonus clone() {
		try {
			return (CartaBonus) super.clone();
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
}
