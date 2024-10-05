package poo23;

import java.util.Scanner;

public class Main 
{
    public static void main( String[] args )
    {
        Volo volo = new Volo();

        Scanner sc = new Scanner(System.in);

        System.out.print("Digita l'origine: ");
        String origine = sc.nextLine();
        System.out.print("Digita la destinazione: ");
        String destinazione = sc.nextLine();
        System.out.print("Digita il codice univoco: ");
        String codice = sc.nextLine();
        System.out.print("Digita la x: ");
        int x = sc.nextInt();
        System.out.print("Digita la y: ");
        int y = sc.nextInt();
        System.out.print("Digita la z: ");
        int z = sc.nextInt();
        sc.nextLine();
        System.out.println();

        RottaAerea rotta1 = new RottaAerea(origine, destinazione, codice, new Coordinate(x, y, z)); 
        RottaAerea rotta2 = new RottaAerea("Roma", "Napoli", "2", new Coordinate(2, 2, 2));
        RottaAerea rotta3 = new RottaAerea("Roma", "Milano", "3", new Coordinate(3, 3, 3));
        volo.aggiungiRotta(rotta1);
        volo.aggiungiRotta(rotta2);
        volo.aggiungiRotta(rotta3);

        // Stampa voli
        for(RottaAerea r : volo.getVoli())
            System.out.println(r);
        System.out.println();

        System.out.print("Voli con origine: ");
        String origine2 = sc.nextLine();

        int count=0;
        for(RottaAerea r : volo.getVoli())
            if(r.getOrigine().equals(origine2)){  
                count++;
                System.out.println(r);
            }
        System.out.println("Numero di voli con origine "+origine2+": "+count);

        sc.close();
    }
}
