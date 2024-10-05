package esercizio1;

public class VacanzaMontagna extends Vacanza{
	private int sauneGratis;

	public VacanzaMontagna(int id, int costo, String descrizione, int sauneGratis) {
		super(id, costo+=(sauneGratis * 10), descrizione);
		this.sauneGratis = sauneGratis;
	}

	public int getSauneGratis() {
		return sauneGratis;
	}

	public void setSauneGratis(int sauneGratis) {
		this.sauneGratis = sauneGratis;
	}

	public String toString() {
		return super.toString() + "[sauneGratis=" + sauneGratis + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj)) return false;
		
		VacanzaMontagna vm = (VacanzaMontagna) obj;
		return sauneGratis == vm.sauneGratis;
	}
}
