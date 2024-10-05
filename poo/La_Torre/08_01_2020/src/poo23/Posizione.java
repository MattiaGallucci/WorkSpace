package poo23;

public class Posizione implements Cloneable{
	private int x;
	private int y;
	
	public Posizione(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Posizione [x=" + x + ", y=" + y + "]";
	}
	
	public Posizione clone() {
		try {
			return (Posizione) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
