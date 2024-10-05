package poo23.eccezioni;

public class DivisionePerZeroException extends RuntimeException {
	public DivisionePerZeroException() {
		super("Divisione per zero!");
	}

	public DivisionePerZeroException(String msg) {
		super(msg);
	}
}