package it.unisa.scuola;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainApp {
	public static void main(String[] args) {
		//Creazione di una classe
		Classe classe = new Classe("Resto 1");
		Classe classe2 = new Classe("Resto 2");
		
		//Creazione docenti
		Docente doc1 = new Docente("A001", "Christian", "Esposito", "Programmazione OO");
		Docente doc2 = new Docente("B002", "Giuseppe", "Polese", "Basi di Dati");
		try {
			classe.putDocente(doc1);
			classe.putDocente(doc2);
			classe2.putDocente(doc2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Classe " + classe);
		
		//Creazione studenti
		Studente stu1 = new Studente("C003", "Mario", "Rossi", "052001");
		Studente stu2 = new Studente("C004", "Francesca", "De Sio", "052001");
		Studente stu3 = new Studente("C005", "Ornella", "Muti", "052001");
		classe.putStudente(stu1);
		classe.putStudente(stu2);
		classe.putStudente(stu3);
		System.out.println("Classe " + classe);
		
		//Creazione voti
		Votazione votoA = new Votazione(doc1, 18.0, new GregorianCalendar(2021, Calendar.OCTOBER, 27).getTime());
		stu1.addVoto(votoA);
		Votazione votoB = new Votazione(doc1, 28.0, new GregorianCalendar(2021, Calendar.OCTOBER, 27).getTime());
		stu2.addVoto(votoB);
		Votazione votoC = new Votazione(doc1, 30.0, new GregorianCalendar(2021, Calendar.OCTOBER, 27).getTime());
		stu3.addVoto(votoC);
		Votazione votoD = new Votazione(doc2, 21.0, new GregorianCalendar(2021, Calendar.OCTOBER, 25).getTime());
		stu1.addVoto(votoD);
		Votazione votoE = new Votazione(doc2, 27.0, new GregorianCalendar(2021, Calendar.OCTOBER, 25).getTime());
		stu3.addVoto(votoE);
		System.out.println("Classe " + classe);
		
		//Calcolo media
		System.out.println("Media studente " + stu1.getCF() + " = " + stu1.average());
		System.out.println("Media studente " + stu3.getCF() + " = " + stu3.average());
		System.out.println("Media classe " + classe.getNome() + " = " + classe.average());
		
		return;
	}
}
