/* 
Implementare un programma Java per la gestione di un magazzino per le seguenti
tipologie di prodotti:
    Bevande – caratterizzati da un nome, produttore, costo per confezione e
    distributore;
    Frutta - caratterizzati da un nome, produttore, luogo di provenienza, costo per
    confezione e distributore;
    Carne – caratterizzati da un nome, produttore, luogo di provenienza, costo per
    confezione e distributore;
    Detersivi – caratterizzati da un nome, produttore, costo per confezione e
    distributore.
 Il programma presentare un menù a video per la gestione dei prodotti
(inserimento e/o cancellazione prodotti), e la stampa di un riassuntivo dei
prodotti, effettuabile su un file o a video, secondo la scelta dell’utente. 
*/

package poo23;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main( String[] args ){
        Scanner sc = new Scanner(System.in);
        int scelta=0;
        Magazzino<Prodotto> magazzino = new Magazzino<>();
        List<Prodotto> bevandeList = new ArrayList<>();
        List<Prodotto> fruttaList = new ArrayList<>();
        List<Prodotto> carneList = new ArrayList<>();
        List<Prodotto> detersiviList = new ArrayList<>();
        
        Prodotto bevanda1 = new Prodotto("Coca Cola", "Pepsi", 1.5, "Farmacia");
        Prodotto bevanda2 = new Prodotto("Acqua", "Aquafina", 1.0, "Farmacia");
        bevandeList.add(bevanda1);
        bevandeList.add(bevanda2);
        Prodotto frutta1 = new Prodotto_Reperibile<>("Uva", "Roma", 2.5, "Farmacia", "Roma");
        Prodotto frutta2 = new Prodotto_Reperibile<>("Mela", "Milano", 2.5, "Farmacia", "Napoli");
        fruttaList.add(frutta1);
        fruttaList.add(frutta2);
        Prodotto carne1 = new Prodotto_Reperibile<>("Pollo", "Firenza", 2.5, "Farmacia", "Milano");
        Prodotto carne2 = new Prodotto_Reperibile<>("Carne", "Avellino", 2.5, "Farmacia", "Napoli");
        carneList.add(carne1);
        carneList.add(carne2);
        Prodotto detersivo1 = new Prodotto ("Sabonete", "Crema", 1.5, "Farmacia");
        Prodotto detersivo2 = new Prodotto ("Mastro Lindo", "Sulco", 1.5, "Farmacia");
        detersiviList.add(detersivo1);
        detersiviList.add(detersivo2);
        
        magazzino.aggiungi("bevande", bevandeList);
        magazzino.aggiungi("frutta", fruttaList);
        magazzino.aggiungi("carne", carneList);
        magazzino.aggiungi("detersivi", detersiviList);

        System.out.println("1: Bevande");
        System.out.println("2: Frutta");
        System.out.println("3: Carne");
        System.out.println("4: Detersivi");
        System.out.print("Seleziona un prodotto: ");
        scelta = sc.nextInt();
        
        switch(scelta)
        {
            case 1:
                System.out.println("");
                System.out.println("1: Visualizza bevande");
                System.out.println("2: Aggiungi bevande");
                System.out.println("3: Rimuovi bevande");
                System.out.print("Scegli l'operazione da eseguire: ");
                scelta = sc.nextInt();
                switch(scelta)
                {
                    case 1:
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("bevande"))
                            System.out.println(element);
                        break;
                    case 2:
                        System.out.println("");
                        Prodotto addP = new Prodotto("", "", 0, "");
                        addP = addP.aggiungiProdotto(addP);
                        bevandeList.add(addP);
                        
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("bevande"))
                            System.out.println(element);
                        break;
                    case 3:
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("bevande"))
                            System.out.println(element);
                        System.out.println("");
                        
                        Prodotto remP = new Prodotto("", "", 0, "");
                        remP = remP.rimuoviProdotto(remP);
                        magazzino.rimuovi("bevande", remP);

                        
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("bevande"))
                            System.out.println(element);
                        break;
                }
                break;
            
            case 2:
                System.out.println("");
                System.out.println("1: Visualizza frutta");
                System.out.println("2: Aggiungi frutta");
                System.out.println("3: Rimuovi frutta");
                System.out.print("Scegli l'operazione da eseguire: ");
                scelta = sc.nextInt();
                switch(scelta)
                {
                    case 1:
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("frutta"))
                            System.out.println(element);
                        break;
                    case 2:
                        System.out.println("");
                        Prodotto_Reperibile<Prodotto> addP = new Prodotto_Reperibile<>("", "", 0, "", "");
                        addP = addP.aggiungiProdotto(addP);
                        fruttaList.add(addP);
                        
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("frutta"))
                            System.out.println(element);
                        break;
                    case 3:
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("frutta"))
                            System.out.println(element);
                        System.out.println("");
                        
                        Prodotto remP = new Prodotto("", "", 0, "");
                        remP = remP.rimuoviProdotto(remP);
                        magazzino.rimuovi("frutta", remP);

                        
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("frutta"))
                            System.out.println(element);
                        break;
                }
                break;
            
            case 3:
                System.out.println("");
                System.out.println("1: Visualizza carne");
                System.out.println("2: Aggiungi carne");
                System.out.println("3: Rimuovi carne");
                System.out.print("Scegli l'operazione da eseguire: ");
                scelta = sc.nextInt();
                switch(scelta)
                {
                    case 1:
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("carne"))
                            System.out.println(element);
                        break;
                    case 2:
                        System.out.println("");
                        Prodotto_Reperibile<Prodotto> addP = new Prodotto_Reperibile<>("", "", 0, "", "");
                        addP = addP.aggiungiProdotto(addP);
                        carneList.add(addP);
                        
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("carne"))
                            System.out.println(element);
                        break;
                    case 3:
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("carne"))
                            System.out.println(element);
                        System.out.println("");
                        
                        Prodotto remP = new Prodotto("", "", 0, "");
                        remP = remP.rimuoviProdotto(remP);
                        magazzino.rimuovi("carne", remP);

                        
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("carne"))
                            System.out.println(element);
                        break;
                }
                break;
            
            case 4:
                System.out.println("");
                System.out.println("1: Visualizza detersivi");
                System.out.println("2: Aggiungi detersivi");
                System.out.println("3: Rimuovi detersivi");
                System.out.print("Scegli l'operazione da eseguire: ");
                scelta = sc.nextInt();

                switch(scelta)
                {
                    case 1:
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("detersivi"))
                            System.out.println(element);
                        break;
                    case 2:
                        System.out.println("");
                        Prodotto addP = new Prodotto("", "", 0, "");
                        addP = addP.aggiungiProdotto(addP);
                        detersiviList.add(addP);
                        
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("detersivi"))
                            System.out.println(element);
                        break;
                    case 3:
                        System.out.println("");
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("detersivi"))
                            System.out.println(element);
                        System.out.println("");
                        
                        Prodotto remP = new Prodotto("", "", 0, "");
                        remP = remP.rimuoviProdotto(remP);
                        magazzino.rimuovi("detersivi", remP);

                        
                        System.out.println("");
                        for (Prodotto element : magazzino.getProdotti("detersivi"))
                            System.out.println(element);
                        break;
                }
                break;
            
            default:
                System.out.println("Opzione non valida");
                break;
        } 
        sc.close();
    }
}