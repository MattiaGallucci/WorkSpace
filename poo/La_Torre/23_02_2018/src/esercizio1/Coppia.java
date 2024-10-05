package esercizio1;

public class Coppia<T> implements Cloneable{
	private T oggetto1;
	private T oggetto2;
	
	public Coppia(T oggetto1, T oggetto2) {
		this.oggetto1 = oggetto1;
		this.oggetto2 = oggetto2;
	}

	public T getOggetto1() {
		return oggetto1;
	}

	public void setOggetto1(T oggetto1) {
		this.oggetto1 = oggetto1;
	}

	public T getOggetto2() {
		return oggetto2;
	}

	public void setOggetto2(T oggetto2) {
		this.oggetto2 = oggetto2;
	}

	public String toString() {
		return getClass().getName() + " [oggetto1=" + oggetto1 + ", oggetto2=" + oggetto2 + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coppia<T> other = (Coppia<T>) obj;
		return oggetto1.equals(other.oggetto1) && oggetto2.equals(other.oggetto2);
	}

	public Coppia<T> clone(){
		try {
			return (Coppia<T>) super.clone();
		}catch (CloneNotSupportedException e) {
			return null;
		}	
	}
}
