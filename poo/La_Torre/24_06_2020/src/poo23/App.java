package poo23;

public class App {
	public static void main(String[] args) {
		MonetaDaCollezione moneta1 = new MonetaDaCollezione(10, 2000, new Proprietario(null, null), new Certificato(2002, 2025, null, null));
		MonetaDaCollezione moneta2 = new MonetaDaCollezione(20, 2000, new Proprietario(null, null), new Certificato(2002, 2025, null, null));
		MonetaDaCollezione moneta3 = new MonetaDaCollezione(50, 2027, new Proprietario(null, null), new Certificato(2002, 2025, null, null));
		MonetaDaCollezione moneta4 = new MonetaDaCollezione(20, 2000, new Proprietario(null, null), new Certificato(2002, 2022, null, null));
		
		CollezioneMonete collezione = new CollezioneMonete();
		
		collezione.aggiungiMoneta(moneta1);
		collezione.aggiungiMoneta(moneta2);
		//collezione.aggiungiMoneta(moneta3);	ECCEZIONE NON CONTROLLATA
		//collezione.aggiungiMoneta(moneta4);	ECCEZIONE CONTROLLATA
		
		try {
			collezione.check();
		} catch (ExpiredCertificateException e) {
			System.out.println(e.getMessage());
		}
	}
}
