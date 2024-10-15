
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class LibreriaMusicaleClient {

    static Logger logger = Logger.getLogger("global");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome = "", link = "", titolo = "";
        ArrayList<String> canzoni = new ArrayList<>();
        try {
            logger.info("Cerco oggetto remoto...");
            LibreriaMusicale libreriaMusicale = (LibreriaMusicale) Naming.lookup("rmi://localhost/LibreriaMusicale");

            logger.info("... Trovato!");

            System.out.println(libreriaMusicale.getCanzoni());

            System.out.println("Aggiungi titolo canzone: ");
            titolo = sc.nextLine();
            System.out.println("Aggiungi link canzone: ");
            link = sc.nextLine();
            libreriaMusicale.addCanzone(titolo, link);
            System.out.println(libreriaMusicale.getCanzoni());

            System.out.println("Crea nome playlist: ");
            nome = sc.nextLine();
            System.out.println("Scrivi i titoli delle canzoni da aggiungere alla playlist (digita 'fine' per terminare):");

            while (true) {
                System.out.print("Titolo canzone: ");
                titolo = sc.nextLine();

                // Condizione di uscita: l'utente digita 'fine'
                if (titolo.equalsIgnoreCase("fine")) {
                    break;
                }

                // Aggiungi il titolo alla lista delle canzoni della playlist
                if (libreriaMusicale.getCanzoni().containsKey(titolo)) {
                    canzoni.add(titolo);
                } else {
                    System.out.println("Canzone non trovata nella libreria. Prova di nuovo.");
                }
            }
            
            libreriaMusicale.creaPlaylist(nome, canzoni);
            
            System.out.println("Scrivi nome della playlist/canzone da riprodurre:");
            nome = sc.nextLine();
            
            System.out.println(libreriaMusicale.riproduci(nome));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
