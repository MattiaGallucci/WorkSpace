package client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import server.RistoranteEJBRemote;

public class Client {

    private static RistoranteEJBRemote ejb;

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        
        /* Ipotizzando che il nome dell'EJB Module sia Esame e che il nome del pacchetto sia esame */
        ejb = (RistoranteEJBRemote) ctx.lookup("java:global/GALLUCCIMATTIA_Server/RistoranteEJB!server.RistoranteEJBRemote");
        
        System.out.println(ejb.trovaPerTipoTavolo("VIP"));
        System.out.println(ejb.trovaPerNumeroPersone(9));
    }
}
