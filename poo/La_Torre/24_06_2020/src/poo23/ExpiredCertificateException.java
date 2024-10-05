package poo23;

public class ExpiredCertificateException extends Exception{
	public ExpiredCertificateException() {
		super("Certificato scaduto");
	}
}
