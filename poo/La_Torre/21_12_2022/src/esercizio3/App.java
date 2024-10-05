package esercizio3;

import esercizio1.CentroUrbano;
import esercizio1.Nazione;

public class App {
	public static void main(String[] args) {
		class CriterioRangeAbitanti implements Criterio<CentroUrbano>{
			public boolean useCriterio(CentroUrbano item) {
				if(item.getAbitanti() >= 200 && item.getAbitanti() <= 500)
					return true;
				else
					return false;
			}
		}
		Criterio<CentroUrbano> rangeAbitanti = new CriterioRangeAbitanti();
		
		class CriterioNazione implements Criterio<CentroUrbano>{
			public boolean useCriterio(CentroUrbano item) {
				if(item.getNazione().getNome().equals("Italia"))
					return true;
				else
					return false;
			}
		}
		Criterio<CentroUrbano> criterioNazione = new CriterioNazione();
		
		Centri<CentroUrbano> centri = new Centri<CentroUrbano>();
		
		CentroUrbano c1 = new CentroUrbano("1", new Nazione("Italia", 0), 500, 0);
		CentroUrbano c2 = new CentroUrbano("2", new Nazione("Italia", 0), 200, 0);
		CentroUrbano c3 = new CentroUrbano("3", new Nazione("NO", 0), 700, 0);
		CentroUrbano c4 = new CentroUrbano("4", new Nazione("Italia", 0), 550, 0);
		CentroUrbano c5 = new CentroUrbano("5", new Nazione("NO", 0), 50, 0);
		CentroUrbano c6 = new CentroUrbano("6", new Nazione("NO", 0), 5080, 0);
		CentroUrbano c7 = new CentroUrbano("7", new Nazione("NO", 0), 400, 0);
		
		
		centri.aggiungi(c1);
		centri.aggiungi(c2);
		centri.aggiungi(c3);
		centri.aggiungi(c4);
		centri.aggiungi(c5);
		centri.aggiungi(c6);
		centri.aggiungi(c7);
		
		centri.setCriterio(rangeAbitanti);
		System.out.println(centri.getCentriByCriterio());
		centri.setCriterio(criterioNazione);
		System.out.println(centri.getCentriByCriterio());
		
	}
}
