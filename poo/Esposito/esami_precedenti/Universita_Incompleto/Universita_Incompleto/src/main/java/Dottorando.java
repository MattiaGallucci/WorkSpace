import java.util.StringTokenizer;

public class Dottorando extends Studente {

	public Dottorando(String nome, String cognome, String matricola) {
		super(nome, cognome, matricola);
		// TODO Auto-generated constructor stub
	}

	public static Dottorando create(String str) {
		return (Dottorando) Studente.create(str);
	}
}
