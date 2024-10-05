import java.util.StringTokenizer;

public class Studente extends Persona {
	private String matricola;

	public Studente(String nome, String cognome, String matricola) {
		super(nome, cognome);
		this.matricola = matricola;
	}
	
	public static Studente create(String str) {
		StringTokenizer st = new StringTokenizer(str,",");    
	    if(st.countTokens() != 3)
	    	throw new IllegalArgumentException("I need 3 tokens");
	    else
			return new Studente(st.nextToken(), st.nextToken(), st.nextToken()); 
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	@Override
	public String toString() {
		return super.toString() + "," + matricola;
	}
}
