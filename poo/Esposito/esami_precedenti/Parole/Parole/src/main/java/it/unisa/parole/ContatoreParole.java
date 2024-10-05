package it.unisa.parole;

public class ContatoreParole extends Contatore<String> {
	@Override
	protected int contaElem(String elem) {
		return 1;
	}

	@Override
	protected IteratoreParole createIterator(String str) {
		return new IteratoreParole(str);
	}

}
