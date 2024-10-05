package poo23;

public class EmptyListException extends Exception{
	public EmptyListException() {
		super("Lista vuota");
	}
	
	public EmptyListException(String msg) {
		super(msg);
	}
}
