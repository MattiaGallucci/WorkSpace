package esercizio2;

import java.util.ArrayList;

import esercizio1.Appartamento;
import esercizio1.Certificato;
import esercizio1.Indirizzo;

public class App {
	public static void main(String[] args) {
		Appartamento a1 = new Appartamento(null, null, 25000, 0, 8, new Certificato(null, "A"));
		Appartamento a2 = new Appartamento(null, null, 12000, 0, 3, new Certificato(null, "D"));
		Appartamento a3 = new Appartamento(null, null, 350000, 0, 15, new Certificato(null, "B"));
		Appartamento a4 = new Appartamento(null, null, 2000, 0, 2, new Certificato(null, "E"));
		Appartamento a5 = new Appartamento(null, null, 100000, 0, 10, new Certificato(null, "A"));
		
		Indirizzo i1 = new Indirizzo("Milano", 1, "Via 1", 11);
		Indirizzo i2 = new Indirizzo("Napoli", 2, "Via 2", 22);
		Indirizzo i3 = new Indirizzo("Roma", 3, "Via 3", 33);
		Indirizzo i4 = new Indirizzo("Salerno", 4, "Via 4", 44);
		Indirizzo i5 = new Indirizzo("Avellino", 5, "Via 5", 55);
		
		ArrayList<Appartamento> appList = new ArrayList<>();
		appList.add(a1);
		appList.add(a2);
		appList.add(a3);
		appList.add(a4);
		appList.add(a5);
		
		ArrayList<Indirizzo> indList = new ArrayList<>();
		indList.add(i1);
		indList.add(i2);
		indList.add(i3);
		indList.add(i4);
		indList.add(i5);
		
		Criterio<Appartamento> criterioAppartamento = new Criterio<Appartamento>() {
			public String usaCriterio(Appartamento item) {
				String s = "" + item.getStanze() + " " + item.getPrezzo() + " " + item.getCertificato().getCategoria();
				return s;
			}
		};
		Algoritmo algoritmoAppartamento = new Algoritmo();
		System.out.println(algoritmoAppartamento.estrai(appList, criterioAppartamento));
		
		Criterio<Indirizzo> criterioIndirizzo = new Criterio<Indirizzo>() {
			public String usaCriterio(Indirizzo item) {
				String s = "" + item.getVia() + " " + item.getNumero() + " " + item.getCap();
				return s;
			}
		};
		Algoritmo algoritmoIndirizzo = new Algoritmo();
		System.out.println(algoritmoIndirizzo.estrai(indList, criterioIndirizzo));
	}
}