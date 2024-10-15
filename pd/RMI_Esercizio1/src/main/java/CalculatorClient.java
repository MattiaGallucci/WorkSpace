
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Logger;

public class CalculatorClient {
    static Logger logger = Logger.getLogger("global");
    
    public static void main(String[] args){
        try{
            logger.info("Cerco oggetto remoto...");
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost/Calcolatrice");
            
            logger.info("Trovato!");
            System.out.println(calc.somma(4, 3));
            System.out.println(calc.sottrazione(2.2, 5.2));
            System.out.println(calc.moltiplicazione(5, 5));
            System.out.println(calc.divisione(3, 0));
            System.out.println(calc.divisione(6, 2));
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
