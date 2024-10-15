package esercizio1;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.security.Permission;
import java.util.logging.Logger;

public class HelloImpl extends UnicastRemoteObject implements Hello {

    static Logger logger = Logger.getLogger("global");

    public HelloImpl() throws RemoteException {
    } //COSTRUTTORE

    public String dimmiQualcosa(String qualcosa) throws RemoteException {
        logger.info("Sto salutando " + qualcosa);
        return "Ciao " + qualcosa;
    }

    public static void main(String[] args) throws RemoteException {
        //questo codice permette di evitare di scrivere il file policy
        System.setSecurityManager(new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) {
            }
            @Override
            public void checkPermission(Permission perm, Object context) {
            }
        });
        try {
            logger.info("Creo l'oggetto remoto...");
            HelloImpl obj = new HelloImpl();

            logger.info("... ne effettuo il rebind...");
            Naming.rebind("HelloServer", obj);

            logger.info("... Pronto!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
