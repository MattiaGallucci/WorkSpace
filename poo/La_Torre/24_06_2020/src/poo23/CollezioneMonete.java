package poo23;

import java.util.ArrayList;
import java.util.List;

public class CollezioneMonete{
	private List<MonetaDaCollezione> collezione;

	public CollezioneMonete() {
		collezione = new ArrayList<>();
	}
	
	public void aggiungiMoneta(MonetaDaCollezione moneta) {
		if(moneta.getAnno() > 2023)
			throw new WrongYearException();
		collezione.add(moneta);
	}
	
	public void check() throws ExpiredCertificateException{
		for(MonetaDaCollezione moneta : collezione)
			if(moneta.eScaduto())
				throw new ExpiredCertificateException();
	}
}
