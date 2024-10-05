package it.unisa.parole;

public class ContatoreManiuscole extends Contatore<Character> {
	
	@Override
	protected int contaElem(Character lettera) {
		if(Character.isUpperCase(lettera)) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	protected IteratoreLettere createIterator(String str) {
		return new IteratoreLettere(str);
	}
}
