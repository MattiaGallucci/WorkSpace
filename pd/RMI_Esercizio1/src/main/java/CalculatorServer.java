import java.rmi.Naming;
import java.rmi.RemoteException;
import java.security.Permission;
import java.util.logging.Logger;

public class CalculatorServer {
    static Logger logger = Logger.getLogger("global");
    
    public static void main(String[] args) throws RemoteException{
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
            }
            @Override
            public void checkPermission(Permission perm, Object context) {
            }
        });
        
        try{
            logger.info("Creo l'oggetto remoto...");
            CalculatorImpl calc = new CalculatorImpl();
            
            logger.info("Effettuo rebind...");
            Naming.rebind("Calcolatrice", calc);
            
            logger.info("... Pronto!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
