
import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Logger;

public class ElezioniClient {
    static Logger logger = Logger.getLogger("global");
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String candidato="";
        try{
            logger.info("Cerco oggetto remoto...");
            Elezioni elezioni = (Elezioni) Naming.lookup("rmi://localhost/Elezioni");
            
            logger.info("Trovato!");
            
            System.out.println(elezioni.getCandidati());
            
            System.out.println("Chi vuoi votare: ");
            candidato = sc.nextLine();
            System.out.println(elezioni.votaCandidato(candidato));
            
            System.out.println(elezioni.getRisultati());
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
