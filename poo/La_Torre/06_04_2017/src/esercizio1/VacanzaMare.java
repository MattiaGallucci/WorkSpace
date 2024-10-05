package esercizio1;

public class VacanzaMare extends Vacanza{
	private boolean servizioSpiaggia;

	public VacanzaMare(int id, int costo, String descrizione, boolean servizioSpiaggia) {
		super(id, costo, descrizione);
		this.servizioSpiaggia = servizioSpiaggia;
		if(servizioSpiaggia)
			costo += 50;
	}

	public boolean isServizioSpiaggia() {
		return servizioSpiaggia;
	}

	public void setServizioSpiaggia(boolean servizioSpiaggia) {
		this.servizioSpiaggia = servizioSpiaggia;
	}

	public String toString() {
		return super.toString() + "[servizioSpiaggia=" + servizioSpiaggia + "]";
	}
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		if (!super.equals(obj)) return false;
		
		VacanzaMare vm = (VacanzaMare) obj;
		return servizioSpiaggia == vm.servizioSpiaggia;
	}
}
