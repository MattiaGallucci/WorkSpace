package esercizio2;

import esercizio1.CentroUrbano;
import esercizio1.Nazione;

public class CentroUrbanoMappa extends CentroUrbano{
	
	private PuntoMappa puntoMappa;
	
	public CentroUrbanoMappa(String unNome, Nazione unaNazione, int unNumeroAbitanti, double unaTemperatura, PuntoMappa unPuntoMappa) {
		super(unNome, unaNazione, unNumeroAbitanti, unaTemperatura);
		puntoMappa=unPuntoMappa;
	}
	
	public String toString(){
		return super.toString() + "[puntoMappa="+puntoMappa+"]";		
	}
	
	public boolean equals(Object obj){
		if(!super.equals(obj))
			return false;
		CentroUrbanoMappa tmp = (CentroUrbanoMappa) obj;
		return puntoMappa.equals(tmp.puntoMappa);
	}
	
	
	//metodi di accesso
	public PuntoMappa getPuntoMappa(){
		return puntoMappa;
	}
	
	//metodi modificatori
	public void changePuntoMappa(PuntoMappa newPuntoMappa){
		puntoMappa=newPuntoMappa;
	}
}
