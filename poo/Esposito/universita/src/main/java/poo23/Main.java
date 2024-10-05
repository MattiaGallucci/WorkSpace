package poo23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void stampaOpzioni() {
        System.out.println();
        System.out.println("1: Visualizza Docenti");
        System.out.println("2: Visualizza Studenti");
        System.out.println("3: Aggiungi Docente");
        System.out.println("4: Aggiungi Studente");
        System.out.println("5: Visualizza studenti con voto maggiore di x");
        System.out.print("Seleziona una opzione: ");
    }

    public static void stampaErrore(){
        System.out.println();
        System.out.println("Opzione non valida");
    }
    public static void main(String[] args) {
        int scelta, voto;
        Scanner sc = new Scanner(System.in);
        Universita universita = new Universita();
        List<Studente> s1List = new ArrayList<>();
        List<Studente> s2List = new ArrayList<>();
        List<Studente> s3List = new ArrayList<>();
        List<Docente> d1List = new ArrayList<>();
        List<Docente> d2List = new ArrayList<>();
        List<Docente> d3List = new ArrayList<>();
        List<Object> classe1 = new ArrayList<>();
        List<Object> classe2 = new ArrayList<>();
        List<Object> classe3 = new ArrayList<>();

        Studente s1 = new Studente("Pippo", "Bianchi", 0, 2000, true, 25);
        Studente s2 = new Studente("Gino", "Rossi", 1, 2000, false, 24);
        Studente s3 = new Studente("Giulio", "Verdi", 2, 2000, false, 27);
        s1List.add(s1);
        s1List.add(s2);
        s1List.add(s3);
        Studente s4 = new Studente("Giuseppe", "Gialli", 3, 2000, false, 18);
        Studente s5 = new Studente("Chicca", "Ingino", 4, 2000, true, 30);
        Studente s6 = new Studente("Mattia", "Gallucci", 5, 2000, false, 30);
        s2List.add(s4);
        s2List.add(s5);
        s2List.add(s6);
        Studente s7 = new Studente("Peppe", "Gialli", 6, 2000, false, 14);
        Studente s8 = new Studente("Totore", "Gialli", 7, 2000, false, 25);
        Studente s9 = new Studente("Totò", "Gialli", 8, 2000, true, 22);
        s3List.add(s7);
        s3List.add(s8);
        s3List.add(s9);
        Docente d1 = new Docente("Gino", "Rossi", "Informatica", true);
        Docente d4 = new Docente("Carolina", "Ingino", "Informatica", true);
        d1List.add(d1);
        d1List.add(d4);
        Docente d2 = new Docente("Giulio", "Verdi", "Biologia", true);
        Docente d5 = new Docente("Giuseppe", "Gialli", "Biologia", true);
        d2List.add(d2);
        d2List.add(d5);
        Docente d3 = new Docente("Giuseppe", "Gialli", "Fisica", true);
        Docente d6 = new Docente("Giustino", "Verdi", "Fisica", true);
        d3List.add(d3);
        d3List.add(d6);

        classe1.add(d1List);
        classe1.add(s1List);
        classe2.add(d2List);
        classe2.add(s2List);
        classe3.add(d3List);
        classe3.add(s3List);

        universita.aggiungi("Informatica", classe1);
        universita.aggiungi("Biologia", classe2);
        universita.aggiungi("Fisica", classe3);

        System.out.println("1: Classe 1");
        System.out.println("2: Classe 2");
        System.out.println("3: Classe 3");
        System.out.print("Seleziona una classe: ");
        scelta = sc.nextInt();

        switch (scelta)
        {
            case(1):
                stampaOpzioni();
                scelta = sc.nextInt();

                switch (scelta)
                {
                    case(1):
                        System.out.println();
                        // universita.stampaDocenti(universita, "Informatica");
                        universita.stampaPersone(universita, "Informatica", Docente.class);
                        break;
                    case(2):
                        System.out.println();
                        // universita.stampaStudenti(universita, "Informatica");
                        universita.stampaPersone(universita, "Informatica", Studente.class);
                        break;
                    case(3):
                        System.out.println();
                        Docente addD = new Docente("", "", "", false);
                        addD = addD.aggiungiDocente(addD, "Informatica");
                        d1List.add(addD);

                        System.out.println();
                        // universita.stampaDocenti(universita, "Informatica");
                        universita.stampaPersone(universita, "Informatica", Docente.class);
                        break;
                    case(4):
                        System.out.println();
                        Studente addS = new Studente("", "", 0, 0, false, 0);
                        addS = addS.aggiungiStudente(addS);
                        s1List.add(addS);

                        System.out.println();
                        // universita.stampaStudenti(universita, "Informatica");
                        universita.stampaPersone(universita, "Informatica", Studente.class);
                        break;
                    case(5):
                        System.out.println();
                        System.out.print("Voto minimo: ");
                        voto = sc.nextInt();
                        universita.votoMaggiore(universita, "Informatica", voto);
                        break;
                    default:
                        stampaErrore();
                        break;
                }
                break;
            case(2):
                stampaOpzioni();
                scelta = sc.nextInt();
            
                switch (scelta)
                {
                    case(1):
                        System.out.println();
                        // universita.stampaDocenti(universita, "Biologia");
                        universita.stampaPersone(universita, "Biologia", Docente.class);
                        break;
                    case(2):
                        System.out.println();
                        // universita.stampaStudenti(universita, "Biologia");
                        universita.stampaPersone(universita, "Biologia", Studente.class);
                        break;
                    case(3):
                        System.out.println();
                        Docente addD = new Docente("", "", "", false);
                        addD = addD.aggiungiDocente(addD, "Biologia");
                        d2List.add(addD);
                        
                        System.out.println();
                        // universita.stampaDocenti(universita, "Biologia");
                        universita.stampaPersone(universita, "Biologia", Docente.class);
                        break;
                    case(4):
                        System.out.println();
                        Studente addS = new Studente("", "", 0, 0, false, 0);
                        addS = addS.aggiungiStudente(addS);
                        s2List.add(addS);

                        System.out.println();
                        // universita.stampaStudenti(universita, "Biologia");
                        universita.stampaPersone(universita, "Biologia", Studente.class);
                        break;
                    case(5):
                        System.out.println();
                        System.out.print("Voto minimo: ");
                        voto = sc.nextInt();
                        universita.votoMaggiore(universita, "Biologia", voto);
                        break;
                    default:
                        stampaErrore();
                        break;
                }
                break;
            case(3):
                stampaOpzioni();
                scelta = sc.nextInt();
            
                switch (scelta)
                {
                    case(1):
                        System.out.println();
                        // universita.stampaDocenti(universita, "Fisica");
                        universita.stampaPersone(universita, "Fisica", Docente.class);
                        break;
                    case(2):
                        System.out.println();
                        // universita.stampaStudenti(universita, "Fisica");
                        universita.stampaPersone(universita, "Fisica", Studente.class);
                        break;
                    case(3):
                        System.out.println();
                        Docente addD = new Docente("", "", "", false);
                        addD = addD.aggiungiDocente(addD, "Fisica");
                        d3List.add(addD);
                        
                        System.out.println();
                        // universita.stampaDocenti(universita, "Fisica");
                        universita.stampaPersone(universita, "Fisica", Docente.class);
                        break;
                    case(4):
                        System.out.println();
                        Studente addS = new Studente("", "", 0, 0, false, 0);
                        addS = addS.aggiungiStudente(addS);
                        s3List.add(addS);

                        System.out.println();
                        // universita.stampaStudenti(universita, "Fisica");
                        universita.stampaPersone(universita, "Fisica", Studente.class);
                        break;
                    case(5):
                        System.out.println();
                        System.out.print("Voto minimo: ");
                        voto = sc.nextInt();
                        universita.votoMaggiore(universita, "Fisica", voto);
                        break;
                    default:
                        stampaErrore();
                        break;
                }
                break;
            default:
                stampaErrore();
                break;
        }
        sc.close();
    }
}
