package poo23.esercizio1;

import java.util.Comparator;

public class ComparatorComparables<T> implements Comparator<Comparable<T extends Comparable>>{

	public int compare(Comparable<T> o1, Comparable<T> o2) {
		return o1.compareTo(o2);
	}

}
