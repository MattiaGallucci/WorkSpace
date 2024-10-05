package esercizio1;

public final class Certificato implements Cloneable{
	private final String data;
	private final String categoria;
	
	public Certificato(String data, String categoria) {
		this.data = data;
		this.categoria = categoria;
	}

	public String getData() {
		return data;
	}

	public String getCategoria() {
		return categoria;
	}

	public String toString() {
		return getClass().getName() + " [data=" + data + ", categoria=" + categoria + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certificato other = (Certificato) obj;
		return data.equals(other.data) && categoria.equals(other.categoria);
	}
	
	public Certificato clone() {
		try {
			return (Certificato) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	
}
