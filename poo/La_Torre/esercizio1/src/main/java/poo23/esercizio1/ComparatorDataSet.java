package poo23.esercizio1;

public class ComparatorDataSet<T> {
	private T minimum;
	private T maximum;
	private Comparable<T> comp;

	public ComparatorDataSet(Comparable<T> C) {
		minimum = null;
		maximum = null;
		comp = C;
	}

	public T getMaximum() {
		return maximum;
	}

	public T getMinimum() {
		return minimum;
	}

	public void add(T x) {
		
	}
}
