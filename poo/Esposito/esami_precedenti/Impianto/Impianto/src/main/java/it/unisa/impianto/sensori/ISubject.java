package it.unisa.impianto.sensori;

import java.util.Observer;

@SuppressWarnings("deprecation")
public interface ISubject {
	void inserisciObserver(Observer obs);
	void rimuoviObserver(Observer obs);
	void notifica();
}
