package poo23;

public class WrongYearException extends RuntimeException{
	public WrongYearException() {
		super("Anno sbagliato");
	}
}
