import java.util.StringTokenizer;

public class Persona {
	private String nome, cognome;

	public Persona(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public static Persona create(String str) {
		StringTokenizer st = new StringTokenizer(str,",");    
	    if(st.countTokens() != 2)
	    	throw new IllegalArgumentException("I need 2 tokens");
	    else
			return new Persona(st.nextToken(), st.nextToken()); 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	@Override
	public String toString() {
		return nome + "," + cognome;
	}

}
