package esercizio2;

public class EmptyListException extends Exception{
	public EmptyListException() {
		super("Lista vuota");
	}

	public EmptyListException(String message) {
		super(message);
	}
}
