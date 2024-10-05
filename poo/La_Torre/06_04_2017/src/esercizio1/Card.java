package esercizio1;

public class Card implements Cloneable{
	private int sconto;
	private int costo;
	
	public Card(int sconto) {
		this.sconto = sconto;
		costo = sconto*2;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getCosto() {
		return costo;
	}

	public String toString() {
		return getClass().getName() + "[sconto=" + sconto + ", costo=" + costo + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return costo == other.costo && sconto == other.sconto;
	}
	
	public Card clone() {
		try {
			return (Card) super.clone();
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	
}
