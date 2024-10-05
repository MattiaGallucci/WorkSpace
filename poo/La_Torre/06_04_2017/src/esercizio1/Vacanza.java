package esercizio1;

public class Vacanza implements Cloneable{
	private int id;
	private int costo;
	private String descrizione;
	
	public Vacanza(int id, int costo, String descrizione) {
		this.id = id;
		this.costo = costo;
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String toString() {
		return getClass().getName() + "[id=" + id + ", costo=" + costo + ", descrizione=" + descrizione + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacanza other = (Vacanza) obj;
		return costo == other.costo && descrizione.equals(other.descrizione) && id == other.id;
	}
	
	public Vacanza clone() {
		try {
			return (Vacanza) super.clone();
		}catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	
}
