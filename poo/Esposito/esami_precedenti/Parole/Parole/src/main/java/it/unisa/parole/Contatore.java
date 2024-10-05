package it.unisa.parole;

public abstract class Contatore<T> {
	public int conta(String str) {
		int risultato = 0;
		Iteratore<T> it = createIterator(str);
		while(it.hasNext()) {
			risultato += contaElem(it.getNext());
		}
		return risultato;
	}
	
	protected abstract int contaElem(T elem);
	protected abstract Iteratore<T> createIterator(String str);
}
