package esercizio1;

public class LavoratoreOccasionale extends Lavoratore implements Cloneable{
	private int compensoOrario;
	private int oreEffettuate;
	private Profilo profilo;
	
	public LavoratoreOccasionale(String nome, String cognome, Indirizzo indirizzo, double retribuzione, int compensoOrario, int oreEffettuate, Profilo profilo) {
		super(nome, cognome, indirizzo, retribuzione);
		this.compensoOrario = compensoOrario;
		this.oreEffettuate = oreEffettuate;
		this.profilo = profilo;
	}
	
	public void paga() {
		super.paga(compensoOrario * oreEffettuate);
	}

	public int getCompensoOrario() {
		return compensoOrario;
	}

	public void setCompensoOrario(int compensoOrario) {
		this.compensoOrario = compensoOrario;
	}

	public int getOreEffettuate() {
		return oreEffettuate;
	}

	public void setOreEffettuate(int oreEffettuate) {
		this.oreEffettuate = oreEffettuate;
	}

	public Profilo getProfilo() {
		return profilo.clone();
	}

	public void setProfilo(Profilo profilo) {
		profilo = profilo.clone();
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		LavoratoreOccasionale other = (LavoratoreOccasionale) obj;
		return compensoOrario == other.compensoOrario && oreEffettuate == other.oreEffettuate
				&& profilo.equals(other.getProfilo());
	}
	
	public LavoratoreOccasionale clone() {
		try {
			LavoratoreOccasionale l = (LavoratoreOccasionale) super.clone();
			l.profilo = profilo.clone();
			return l;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public String toString() {
		return getClass().getSimpleName() + " [compensoOrario=" + compensoOrario + ", oreEffettuate=" + oreEffettuate + ", profilo=" + profilo + "]";
	}
	
	
	
	
}
