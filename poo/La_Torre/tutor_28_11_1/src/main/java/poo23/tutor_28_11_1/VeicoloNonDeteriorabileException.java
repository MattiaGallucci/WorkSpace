package poo23.tutor_28_11_1;

public class VeicoloNonDeteriorabileException extends RuntimeException{
	public VeicoloNonDeteriorabileException() {
		super("Veicolo non deteriorabile");
	}
	
	public VeicoloNonDeteriorabileException(String msg) {
		super(msg);
	}
}
