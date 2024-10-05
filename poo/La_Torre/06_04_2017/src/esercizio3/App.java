package esercizio3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import esercizio1.Card;
import esercizio1.Vacanza;
import esercizio1.VacanzaMare;
import esercizio1.VacanzaMetropolitana;
import esercizio1.VacanzaMontagna;
import esercizio2.Criterio;
import esercizio2.Algoritmo;

public class App {
	public static void main(String[] args) {
		File f = new File("vacanze.dat");
		ArrayList<Vacanza> lista = new ArrayList<>();
		
		if(f.exists()) {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
				lista.add((Vacanza) in.readObject());
				in.close();
			}catch (IOException | ClassNotFoundException e) {
				e.getMessage();
			}
		} else {
			VacanzaMare v1 = new VacanzaMare(1, 0, "sTandard", false);
			VacanzaMare v2 = new VacanzaMare(2, 0, "o", false);
			VacanzaMontagna v3 = new VacanzaMontagna(3, 0, "o", 0);
			VacanzaMontagna v4 = new VacanzaMontagna(4, 0, "STANDARD", 0);
			VacanzaMetropolitana v5 = new VacanzaMetropolitana(5, 0, "standard", new Card(0));
			VacanzaMetropolitana v6 = new VacanzaMetropolitana(6, 0, "o", new Card(0));
			
			lista.add(v1);
			lista.add(v2);
			lista.add(v3);
			lista.add(v4);
			lista.add(v5);
			lista.add(v6);
		}
		
		Criterio<Vacanza> vacanzaStandardCirterio = new Criterio<>() {
			public boolean usaCriterio(Vacanza item) {
				if(item.getDescrizione().equalsIgnoreCase("standard"))
					return true;
				else
					return false;
			}
		};
		
		Algoritmo criterio = new Algoritmo();
		System.out.println(criterio.estrai(lista, vacanzaStandardCirterio));
	}
}