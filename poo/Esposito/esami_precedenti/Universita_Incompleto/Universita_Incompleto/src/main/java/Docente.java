import java.util.StringTokenizer;

public class Docente extends Persona {
	private String afferenza;
	private boolean isProfessore;
	public Docente(String nome, String cognome, String afferenza, boolean isProfessore) {
		super(nome, cognome);
		this.afferenza = afferenza;
		this.isProfessore = isProfessore;
	}
	
	public static Docente create(String str) {
		StringTokenizer st = new StringTokenizer(str,",");    
	    if(st.countTokens() != 3)
	    	throw new IllegalArgumentException("I need 4 tokens");
	    else
			return new Docente(st.nextToken(), st.nextToken(), st.nextToken(), 
					Boolean.parseBoolean(st.nextToken())); 
	}
	
	public String getAfferenza() {
		return afferenza;
	}
	public void setAfferenza(String afferenza) {
		this.afferenza = afferenza;
	}
	public boolean isProfessore() {
		return isProfessore;
	}
	public void setProfessore(boolean isProfessore) {
		this.isProfessore = isProfessore;
	}
	
	@Override
	public String toString() {
		return super.toString() + "," + afferenza + "," + Boolean.toString(isProfessore);
	}
}
