package it.unisa.parole;

import java.util.Iterator;
import java.util.List;

public class IteratoreParole implements Iteratore<String> {
	private List<String> parole;
	private Iterator<String> i;
	
	public IteratoreParole(String str) {
		parole = List.of(str.split("\\P{L}+"));
		i = parole.iterator();
	}

	@Override
	public String getNext() {
		return i.next();
	}

	@Override
	public boolean hasNext() {
		return i.hasNext();
	}

}
