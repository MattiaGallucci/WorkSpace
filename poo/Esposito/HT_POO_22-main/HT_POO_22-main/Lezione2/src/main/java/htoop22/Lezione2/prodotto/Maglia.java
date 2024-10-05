package htoop22.Lezione2.prodotto;

import htoop22.Lezione2.Prodotto;

public class Maglia extends Prodotto{
	
	public enum Taglia{
		XS,
		S,
		M,
		L,
		XL,
		XXL;
	}
	
	private Taglia taglia;
	private String colore;
	
	public Maglia(String nome, double prezzo, String marca, int qta, Taglia taglia, String colore) {
		super(nome, prezzo, marca, qta);
		this.taglia = taglia;
		this.colore = colore;
	}
	

	public Maglia(Maglia s) {
		super((Prodotto) s);
		this.taglia = s.taglia;
		this.colore = new String(s.colore);
	}

	public Taglia getTaglia() {
		return taglia;
	}

	public void setTaglia(Taglia taglia) {
		this.taglia = taglia;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}
	


}
