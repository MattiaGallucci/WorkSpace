package it.unisa.parole;

public class ContatoreSpecificaParola extends Contatore<String> {
	private String word;

	public ContatoreSpecificaParola(String word) {
		this.word = word;
	}

	@Override
	protected int contaElem(String elem) {
		if(elem.equals(word))
			return 1;
		else
			return 0;
	}

	@Override
	protected IteratoreParole createIterator(String str) {
		return new IteratoreParole(str);
	}

}
