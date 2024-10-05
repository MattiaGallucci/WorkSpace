package esercizio2;

public class ObjectNotFoundException extends RuntimeException{
	public ObjectNotFoundException() {
		super("Oggetto non trovato");
	}
}
