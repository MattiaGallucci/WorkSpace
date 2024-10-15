
import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Logger;

public class HotelClient {
    static Logger logger = Logger.getLogger("global");
    
    public static void main(String[] args) {
        int numero = 0;
        Scanner sc = new Scanner(System.in);
        try{
            logger.info("Cerco oggetto remoto...");
            Hotel hotel = (Hotel) Naming.lookup("rmi://localhost/Hotel");
            
            logger.info("Trovato!");
            
            System.out.println(hotel.getCamere());
            
            System.out.print("Che numero di camera vuoi prenotare: ");
            numero = sc.nextInt();
            
            logger.info("Provo a prenotare...");
            if(hotel.prenotaCamera(numero))
                System.out.println("Prenotato!");
            else
                System.out.println("NON prenotato!");
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
