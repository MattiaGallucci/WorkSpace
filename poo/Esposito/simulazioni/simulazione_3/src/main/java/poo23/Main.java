package poo23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Magazzino<Capi> negozio = new Magazzino<>();
        Scanner sc = new Scanner(System.in);
        int scelta;

        List<Maglia> listaMaglie = new ArrayList<>();
        List<Pantalone> listaPantalone = new ArrayList<>();
        List<Scarpe> listaScarpe = new ArrayList<>();

        Maglia maglia1 = new Maglia(1, "boh", "Gucci", 20, "M");
        listaMaglie.add(maglia1);
        Pantalone pantalone1 = new Pantalone(2, "boh", "LV", 20, 50);
        listaPantalone.add(pantalone1);
        Scarpe scarpe1 = new Scarpe(3, "boh", "J1", 20, 44);
        listaScarpe.add(scarpe1);

        negozio.aggiungi("Maglie", listaMaglie);
        negozio.aggiungi("Pantaloni", listaPantalone);
        negozio.aggiungi("Scarpe", listaScarpe);

        Cliente cliente1 = new Cliente("1A", "Mattia", "Gallucci", 123);

        System.out.println("Quale capo d'abbigliamento vuoi vedere: ");
        visualizzaMenu();
        scelta = sc.nextInt();
        
        switch(scelta){
            case 4:
                int id, scelta2;
                String nome;
                Ordine ordine = new Ordine();
                System.out.println("Quale capo d'abbigliamento vuoi aggiungere: ");
                visualizzaMenu();
                scelta2 = sc.nextInt();
                switch(scelta2){
                    case 1:
                        System.out.print("Inserisci ID: ");
                        id = sc.nextInt();
                        nome = "Maglie";
                        ordine.aggiungiCapi(id);
                        negozio.diminuisciQuantitaInMagazzino(nome, id);
                        for (Capi maglia : negozio.getProdotti("Maglie"))
                            System.out.println(maglia);
                        break;
                }
                break;
        }

        sc.close();

    }

    public static void visualizzaMenu(){
        System.out.println("1. Maglia");
        System.out.println("2. Pantalone");
        System.out.println("3. Scarpe");
        System.out.println("4. Crea ordine");
    }

    public static void visualizzaOperazioni(int scelta, Scanner sc, Magazzino<Capi> negozio){
        switch(scelta){
            case 4:
                int id, scelta2;
                String capo;
                Ordine ordine = new Ordine();
                System.out.print("Quale capo d'abbigliamento vuoi aggiungere: ");
                visualizzaMenu();
                scelta2 = sc.nextInt();
                switch(scelta2){
                    case 1:
                        System.out.print("Inserisci ID: ");
                        id = sc.nextInt();
                        capo = "Maglie";
                        ordine.aggiungiCapi(id);
                        negozio.diminuisciQuantitaInMagazzino(capo, id);
                        for (Capi maglia : negozio.getProdotti("Maglie"))
                            System.out.println(maglia);
                        break;
                }
                break;
        }
    }

    
}