package poo23;

public class ClienteOrdinario extends Cliente{
	private int punti;

	public ClienteOrdinario(String nome, int punti) {
		super(nome);
		this.punti = punti;
	}
	
	public int getPunti() {
		return punti;
	}
	
	public void rimuoviPunti(int punti) {
		this.punti -= punti;
	}
	
	public void aggiungiPunti(int punti) {
		this.punti += punti;
	}
	
	/*public double acquista(double prezzo) {
		int numeroVolteApplicabile=0;
		for(int i=0; i<5 && punti>=5; i++) {
			numeroVolteApplicabile++;
			punti -= 5;
		}
		punti += 1;
		return prezzo - prezzo*0.02*numeroVolteApplicabile;
	}*/

	public String toString() {
		return "ClienteOrdinario [" + super.toString() + " punti=" + punti + "]";
	}
	
	
}
