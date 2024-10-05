package esercizio1;

import esercizio2.Lavoratori;

public class App {
	public static void main(String[] args) {
		LavoratoreDipendente l1 = new LavoratoreDipendente("Chicca", "Ingino", null, 1200, 2020);
		//l1.paga();
		System.out.println(l1.getRetribuzione());
		
		LavoratoreOccasionale l2 = new LavoratoreOccasionale("Mattia", "Gallucci", null, 750, 5, 6, new Profilo(null));
		System.out.println(l2);
		
		Lavoratori lista = new Lavoratori();
		lista.aggiungi(l1);
		lista.aggiungi(l2);
		
		System.out.println(lista.paghe());
	}

}
