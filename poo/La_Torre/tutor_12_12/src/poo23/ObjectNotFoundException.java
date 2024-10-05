package poo23;

public class ObjectNotFoundException extends RuntimeException{
	public ObjectNotFoundException() {
		super("Oggetto non trovato");
	}
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
}
