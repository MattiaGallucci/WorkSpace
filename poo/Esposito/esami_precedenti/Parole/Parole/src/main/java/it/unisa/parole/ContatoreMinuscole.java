package it.unisa.parole;

public class ContatoreMinuscole extends Contatore<Character> {

	@Override
	protected int contaElem(Character lettera) {
		if(Character.isLowerCase(lettera)) {
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
