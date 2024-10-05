package poo23.esercizio1;

import java.util.Comparator;

public class ComparatorComparables <T extends Comparable<T>> implements Comparator<T>{
	public int compare(T o1, T o2) {
		return o1.compareTo(o2);
	}
}
