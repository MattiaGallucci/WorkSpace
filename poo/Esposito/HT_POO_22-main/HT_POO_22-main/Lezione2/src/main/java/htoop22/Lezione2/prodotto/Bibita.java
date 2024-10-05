package htoop22.Lezione2.prodotto;

import htoop22.Lezione2.Prodotto;

public class Bibita extends Prodotto{
	
	private boolean gas;
	private int perc_alcol;

	public Bibita(String nome, double prezzo, String marca, int qta, boolean gas, int perc_alcol) {
		super(nome, prezzo, marca, qta);
		this.gas = gas;
		this.perc_alcol = perc_alcol;
	}
	
	public Bibita(Bibita b) {
		super ((Prodotto) b);
		this.gas = b.gas;
		this.perc_alcol = b.perc_alcol;
	}
	
	public boolean isGas() {
		return gas;
	}
	public void setGas(boolean gas) {
		this.gas = gas;
	}
	public int getPerc_alcol() {
		return perc_alcol;
	}
	public void setPerc_alcol(int perc_alcol) {
		this.perc_alcol = perc_alcol;
	}
	

}
