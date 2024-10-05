package poo23.bank;

public class DataSetMeasurer<T> {
	private double sum;
	private T minimum;
	private T maximum;
	private int count;
	private Measurer<T> measurer;

	public DataSetMeasurer(Measurer<T> M) {
		sum = 0;
		count = 0;
		minimum = null;
		maximum = null;
		measurer = M;
	}

	public double getAverage() {
		if (count == 0)
			return 0;
		else
			return sum / count;
	}

	public T getMaximum() {
		return maximum;
	}

	public T getMinimum() {
		return minimum;
	}

	public void add(T x) {
		sum = sum + measurer.measure(x);
		if (count == 0 || measurer.measure(minimum) > measurer.measure(x))
			minimum = x;
		if (count == 0 || measurer.measure(maximum) < measurer.measure(x))
			maximum = x;
		count++;
	}
}
