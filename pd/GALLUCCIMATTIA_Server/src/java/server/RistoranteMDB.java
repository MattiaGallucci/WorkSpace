package server;

import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class RistoranteMDB implements MessageListener {

    @Inject
    RistoranteEJB ejb;

    @Override
    public void onMessage(Message msg) {
        try {
            MessageWrapper mw = msg.getBody(MessageWrapper.class);
            int id = mw.getId();
            int numeroPersone = mw.getNumeroPersone();
            
            Prenotazione p = ejb.trovaPerId(id);
            if (p == null) {
                System.out.println("La prenotazione non esiste");
                return;
            }

            p.setNumeroPersone(numeroPersone);
            ejb.aggiorna(p);
        } catch (JMSException e) {
            System.out.println("Errore");
        }
    }
}
