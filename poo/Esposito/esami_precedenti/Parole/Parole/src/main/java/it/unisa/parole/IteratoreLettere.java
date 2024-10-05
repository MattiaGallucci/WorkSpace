package it.unisa.parole;

public class IteratoreLettere implements Iteratore<Character> {
	private String str;
	private int i;
	
	public IteratoreLettere(String str) {
		this.str = str;
		i = 0;
	}

	@Override
	public Character getNext() {
		return str.charAt(i++);
	}

	@Override
	public boolean hasNext() {
		return i < str.length();
	}
	
}
