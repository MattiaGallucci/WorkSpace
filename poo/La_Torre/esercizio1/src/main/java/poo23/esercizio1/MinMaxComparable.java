package poo23.esercizio1;

public class MinMaxComparable<T extends Comparable> {
	private T max, min;
	private Comparable<T> comp;

	public MinMaxComparable(T max, T min, Comparable<T> comp) {
		this.max = max;
		this.min = min;
	}

	public void add(T elem) {
		if (max == null || comp.compareTo(elem) < 0)
			max = elem;
		if (min == null || comp.compareTo(elem) > 0)
			min = elem;

	}

	public T getMax() {
		return max;
	}

	public T getMin() {
		return min;
	}

	public void setComp(Comparable<T> comp) {
		this.comp = comp;
	}
}
