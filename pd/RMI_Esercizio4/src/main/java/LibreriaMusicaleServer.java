
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.security.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class LibreriaMusicaleServer {
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
            logger.info("Creo oggetto remoto...");
            
            HashMap<String, String> libreriaMusicale = new HashMap<>();
            HashMap<String, ArrayList<String>> playlist = new HashMap<>();
            HashMap<String, Integer> riproduzioni = new HashMap<>();
            
            libreriaMusicale.put("Canzone1", "link1");
            libreriaMusicale.put("Canzone2", "link2");
            libreriaMusicale.put("Canzone3", "link3");
            libreriaMusicale.put("Canzone4", "link4");
            
            LibreriaMusicaleImpl libreriaMusicaleObj = new LibreriaMusicaleImpl(libreriaMusicale, playlist, riproduzioni);
            
            logger.info("Effettuo rebind...");
            Naming.rebind("LibreriaMusicale", libreriaMusicaleObj);
            
            logger.info("... Pronto!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
