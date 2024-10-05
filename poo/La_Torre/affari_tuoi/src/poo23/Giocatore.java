package poo23;

public class Giocatore {
	public Pacco pacco;

	public Giocatore(Pacco pacco) {
		this.pacco = pacco;
	}
	
	public Pacco getPacco() {
		return pacco;
	}

	public void setPacco(Pacco pacco) {
		this.pacco = pacco;
	}

	@Override
	public String toString() {
		return "Giocatore [pacco=" + pacco + "]";
	}
}
