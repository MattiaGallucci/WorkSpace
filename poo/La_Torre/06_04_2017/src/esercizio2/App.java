package esercizio2;

import java.util.ArrayList;

import esercizio1.Card;
import esercizio1.VacanzaMetropolitana;

public class App {
	public static void main(String[] args) {
		VacanzaMetropolitana v1 = new VacanzaMetropolitana(1, 0, null, new Card(20));
		VacanzaMetropolitana v2 = new VacanzaMetropolitana(2, 0, null, new Card(10));
		VacanzaMetropolitana v3 = new VacanzaMetropolitana(3, 0, null, new Card(50));
		VacanzaMetropolitana v4 = new VacanzaMetropolitana(4, 0, null, new Card(19));
		VacanzaMetropolitana v5 = new VacanzaMetropolitana(5, 0, null, new Card(25));
		VacanzaMetropolitana v6 = new VacanzaMetropolitana(6, 0, null, new Card(10));
		ArrayList<VacanzaMetropolitana> lista = new ArrayList<>();
		lista.add(v1);
		lista.add(v2);
		lista.add(v3);
		lista.add(v4);
		lista.add(v5);
		lista.add(v6);
		
		Criterio<VacanzaMetropolitana> criterioVacanza = new Criterio<>() {
			public boolean usaCriterio(VacanzaMetropolitana item) {
				if(item.getCard().getSconto() >= 20)
					return true;
				else
					return false;
			}
		};
		
		Algoritmo algoritmo = new Algoritmo();
		System.out.println(algoritmo.estrai(lista, criterioVacanza));
	}

}
