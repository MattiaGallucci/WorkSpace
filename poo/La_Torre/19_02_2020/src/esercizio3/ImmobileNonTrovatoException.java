package esercizio3;

public class ImmobileNonTrovatoException extends RuntimeException{
	public ImmobileNonTrovatoException() {
		super("Immobile non trovato");
	}
}
