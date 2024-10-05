package poo23.tutor_21_11;

@SuppressWarnings("serial")
public class LibroDuplicatoException extends Exception{
	public LibroDuplicatoException() {
		super("Impossibile aggiungere libro duplicato");
	}

	public LibroDuplicatoException(String msg) {
		super(msg);
	}
}
