package client;

import java.time.LocalDateTime;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.Prenotazione;
import server.RistoranteEJBRemote;

public class Client {

    private static RistoranteEJBRemote ejb;

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        //modifica nome EJB Module e package
        ejb = (RistoranteEJBRemote) ctx.lookup("java:global/GALLUCCIMATTIA_Server/RistoranteEJB!server.RistoranteEJBRemote");
        
        //VERIFICA EVENTO
        //ejb.crea(new Prenotazione(7, "io", 0, "VIP", LocalDateTime.of(2024, 12, 7, 10, 26)));
        
        //VERIFICA STAMPE
        //System.out.println("Tutte le prenotazioni trovate: " + ejb.trovaTutti());
        //System.out.println("Prenotazione con id 1: " + ejb.trovaPerId(1));
        System.out.println("Prenotazioni trovate per la tipologia tavolo VIP: " + ejb.trovaPerTipoTavolo("VIP"));
        System.out.println("Prenotazioni trovate per numero di persone = 9: " + ejb.trovaPerNumeroPersone(9));
    }
}
