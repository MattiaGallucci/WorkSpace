package poo23.esercizio1;

public class ComparableDataSet<T extends Comparable<T>> {
	private T minimum;
	private T maximum;

	public ComparableDataSet() {
		minimum = null;
		maximum = null;
	}

	public T getMaximum() {
		return maximum;
	}

	public T getMinimum() {
		return minimum;
	}

	public void add(T x) {
		if (minimum == null || (x.compareTo(minimum)) > 0)
			minimum = x;
		else if (maximum == null || (x.compareTo(maximum)) < 0)
			maximum = x;
	}
}
