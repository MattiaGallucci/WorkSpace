package poo23.tutor_07_12;

public class ItemNotFoundException extends RuntimeException{
	public ItemNotFoundException() {
		super("Prodotto non trovato");
	}
}
