package esercizio1;

public class LavoratoreDipendente extends Lavoratore{
	private int annoAssunzione;

	public LavoratoreDipendente(String nome, String cognome, Indirizzo indirizzo, double retribuzione, int annoAssunzione) {
		super(nome, cognome, indirizzo, retribuzione);
		this.annoAssunzione = annoAssunzione;
	}
	
	public void paga() {
		super.paga(1000 * (1+ (((2023-annoAssunzione) * 1.5) / 100)));
	}
	
	
}
