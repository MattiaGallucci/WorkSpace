package allegati;

import java.io.Serializable;

public class Prodotto implements Cloneable,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1866112231930515868L;
	private String denominazione;
	private int peso;
	
	public Prodotto(String denominazione,int peso) {
		this.denominazione = denominazione;
		this.peso = peso;
	}
	
	// metodi object
	
	public Prodotto clone() {
		try {
			Prodotto tmp = (Prodotto)super.clone();
			return tmp;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		Prodotto tmp = (Prodotto)obj;
		return denominazione.equals(tmp.denominazione) && peso == tmp.peso;
	}
	
	
	public String toString() {
		return this.getClass().getName()+"[denominazione="+denominazione+
												",peso="+peso+
												"]";
	}
	
	// metodi di accesso
	
	public String getDenominazione() {
		return denominazione;
	}
	
	public double getPeso() {
		return peso;
	}
	
	// metodi modificatori
	
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}

}
