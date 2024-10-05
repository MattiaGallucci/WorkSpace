package poo23.esercizio1;

public class MinMaxComparator<T> {
	private T min, max;
	private Comparator2 comp;
	
	
	public MinMaxComparator(Comparator2 aComparator) {
		this.comp = aComparator;
		this.max = null;
		this.min = null;
	}
}
