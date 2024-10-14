package clientserverremotesocket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class Client {

    static Logger logger = Logger.getLogger("global");

    public static void main(String[] args) {
        try {
            RecordRegistro r = new RecordRegistro("Rossi", null);
            Socket socket = new Socket("localhost", 7000); //args[0]
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

            out.writeObject(socket);
            out.flush();

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            RecordRegistro res = (RecordRegistro) in.readObject();
            in.close();

            if (res != null) {
                Impiegato imp = new ImpiegatoStub(res.getIndirizzo());
                System.out.println("Nome: " + imp.getNome());
                System.out.println("ID: " + imp.getID());
                System.out.println("Stipendio: " + imp.getStipendio());
                System.out.println("Aumentiamo lo stipendio di 1000 euro");
                System.out.println("Ora il tuo stipendio è di: " + imp.aumentaStipendio(1000));
                ((ImpiegatoStub) imp).close();
            } else {
                System.out.println("Non esiste un oggetto remoto con nome Rossi");
            }
        } catch (Throwable t) {
            logger.severe("Lanciata Throwable: " + t.getMessage());
            t.printStackTrace();
        }
    }
}
