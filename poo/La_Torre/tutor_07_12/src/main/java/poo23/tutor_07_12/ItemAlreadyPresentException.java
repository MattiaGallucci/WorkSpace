package poo23.tutor_07_12;

public class ItemAlreadyPresentException extends Exception{
	public ItemAlreadyPresentException() {
		super("Prodotto già presente");
	}
}
