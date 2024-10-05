package htoop22.Lezione1.prodotto;
import htoop22.Lezione1.Prodotto;

public class Chiavetta extends Prodotto{
	private int spazio;

	public Chiavetta(String nome, double prezzo, String marca, int qta, int spazio) {
		super(nome, prezzo, marca, qta);
		this.spazio = spazio;
	}

	public int getSpazio() {
		return spazio;
	}

	public void setSpazio(int spazio) {
		this.spazio = spazio;
	}
	
	
	
	
}
