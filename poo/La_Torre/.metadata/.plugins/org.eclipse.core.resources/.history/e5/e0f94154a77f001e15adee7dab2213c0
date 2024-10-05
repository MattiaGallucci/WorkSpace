package poo23.bank;

public class DataSet <T extends Measurable>{
	private double sum;
	private T minimum;
	private T maximum;
	private int count;

	public DataSet() {
		sum = 0;
		count = 0;
		minimum = null;
		maximum = null;
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
		sum = sum + x.getMeasure();
		if (count == 0 || minimum.getMeasure() > x.getMeasure())
			minimum = x;
		if (count == 0 || maximum.getMeasure() < x.getMeasure())
			maximum = x;
		count++;
	}
}
