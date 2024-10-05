package poo23.eccezioni_file;

public class BadDataException extends RuntimeException {
	public BadDataException() {
	}

	public BadDataException(String msg) {
		super(msg);
	}
}
