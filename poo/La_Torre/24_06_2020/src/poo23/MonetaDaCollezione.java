package poo23;

public class MonetaDaCollezione extends Moneta implements Certificabile{
	private Proprietario proprietario;
	private Certificato certificato;
	
	public MonetaDaCollezione(int valore, int anno, Proprietario proprietario, Certificato certificato) {
		super(valore, anno);
		this.proprietario = proprietario;
		this.certificato = certificato;
	}

	public Certificato getCertificato() {
		return certificato;
	}
	
	public boolean eScaduto() {
		if(certificato.getDataScadenza() < 2023)
			return true;
		else
			return false;
	}
	
	public Proprietario getProprietario() {
		return proprietario;
	}

	@Override
	public String toString() {
		return "MonetaDaCollezione [proprietario=" + proprietario + ", certificato=" + certificato + "]";
	}

	
	
}
