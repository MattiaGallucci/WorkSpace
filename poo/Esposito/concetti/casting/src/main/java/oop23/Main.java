package oop23;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserisci il nome sesso(m/f) età: ");
        String nome = sc.nextLine();
        String sesso = sc.nextLine();
        int eta = sc.nextInt();
        sc.close();

        Persona carolina = new Persona(nome, sesso, eta);
        carolina.ChiSei();
        System.out.println();

        // UPCASTING
        Persona mattia = new Studente("Mattia", "m", 20, 7, 16893, "Informatica");
        mattia.ChiSei();
        System.out.println();

        // DOWNCASTING
        Persona prova = new Studente("Prova", "m", 23, 5, 12345, "BIO");
        Studente prova1 = (Studente) prova;
        prova1.ChiSei();

    }
}
