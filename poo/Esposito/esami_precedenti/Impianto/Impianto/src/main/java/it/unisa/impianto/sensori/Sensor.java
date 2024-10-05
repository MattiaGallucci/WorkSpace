package it.unisa.impianto.sensori;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public abstract class Sensor<T> extends Observable implements ISubject{
	protected Class<T> obj;

	@Override
	public void inserisciObserver(Observer obs) {
		this.addObserver(obs);
	}

	@Override
	public void rimuoviObserver(Observer obs) {
		this.deleteObserver(obs);
	}

	@Override
	public void notifica() {
		this.setChanged();
		this.notifyObservers(obj);
	} 	
	
	public abstract void setState(T value);
	public abstract T getState(); 
}
