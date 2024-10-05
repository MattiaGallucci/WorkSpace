package esercizio2;

public class MissingItemException extends RuntimeException{
	public MissingItemException() {
		super("Elemento mancante");
	}
}
