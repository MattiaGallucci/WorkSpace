
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class HotelServer {

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

        try {
            logger.info("Creo camere...");
            ArrayList<String> camere = new ArrayList<>(Arrays.asList("Camera1", "Camera2", "Camera3", "Camera4"));
            HotelImpl hotel = new HotelImpl(camere);

            logger.info("Effettuo rebind...");
            Naming.rebind("Hotel", hotel);

            logger.info("... Pronto!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
