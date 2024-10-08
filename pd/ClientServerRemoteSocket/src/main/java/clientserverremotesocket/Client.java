package clientserverremotesocket;

import java.util.logging.Logger;

public class Client {

    static Logger logger = Logger.getLogger("global");

    public static void main(String[] args) {
        try {
            Impiegato imp = new ImpiegatoStub("localhost"); //args[0]
            System.out.println("Nome: " + imp.getNome());
            System.out.println("ID: " + imp.getID());
            System.out.println("Stipendio: " + imp.getStipendio());
            System.out.println("Aumentiamo lo stipendio di 1000 euro");
            System.out.println("Ora il tuo stipendio è di: " + imp.aumentaStipendio(1000));
            ((ImpiegatoStub) imp).close();
            }catch (Throwable t){
            logger.severe("Lanciata Throwable: " + t.getMessage());
            t.printStackTrace();
        }
        }
    }
