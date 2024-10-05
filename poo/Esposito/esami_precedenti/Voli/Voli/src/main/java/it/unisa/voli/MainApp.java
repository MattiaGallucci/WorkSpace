package it.unisa.voli;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;

public class MainApp {

	public static void main(String[] args) {
		Cielo cielo = new Cielo();
		
		//Crea voli
		Scanner scanner = new Scanner(System.in);
		String scelta;
		do {
			try {
				cielo.insertVolo(Volo.createVolo(System.in));
			} catch (Errore e) {
				System.out.println("Mancato inserimento per duplicato");
			}
			
			System.out.println("Continuare? - s/n");
			scelta = scanner.nextLine();
		} while(!scelta.contains("s"));
		
		//Cerca voli per origine
		System.out.println("Indicare origine: ");
		scelta = scanner.nextLine();
		Set<Volo> voli_scelti = null;
		try {
			voli_scelti = cielo.returnVoliOrigine(scelta);
			System.out.println("Trovati " + voli_scelti.size() + " voli partiti da " + scelta);
		} catch (Errore e1) {
			System.out.println("Nessu volo è partito da " + scelta);
		}		
		
		//Stampa su file
		System.out.println("Indicare nome del file: ");
		scelta = scanner.nextLine();
		PrintWriter out = null;
		try {
			out = new PrintWriter(scelta);
			out.print(voli_scelti);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(out!=null) {
				out.close();				
			}
		}
		
		scanner.close();
		return;
	}

}
