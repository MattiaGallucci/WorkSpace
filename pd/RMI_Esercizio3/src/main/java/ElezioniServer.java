
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.security.Permission;
import java.util.HashMap;
import java.util.logging.Logger;

public class ElezioniServer {
    static Logger logger = Logger.getLogger("global");

    public static void main(String[] args) throws RemoteException {
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
            }

            @Override
            public void checkPermission(Permission perm, Object context) {
            }
        });
        
        HashMap<String, Integer> candidati = new HashMap<>();
        
        try{
            logger.info("Creo candidati...");
            candidati.put("Candidato 1", 10);
            candidati.put("Candidato 2", 14);
            candidati.put("Candidato 3", 5);
            candidati.put("Candidato 4", 20);
            
            ElezioniImpl elezioni = new ElezioniImpl(candidati);
            
            logger.info("Effettuo rebind...");
            Naming.rebind("Elezioni", elezioni);
            
            logger.info("... Pronto!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
