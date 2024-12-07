/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viaggi;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class ViaggioMDB implements MessageListener{
    @Inject
    ViaggioEJB ejb;
    
    @Inject
    Event<Viaggio> event;
    
    @Override
    public void onMessage(Message msg) {
        try{
            MessageWrapper mw = msg.getBody(MessageWrapper.class);
            int id = mw.getId();
            int sconto = mw.getSconto();
            
            Viaggio v = ejb.trovaPerId(id);
            
            if(v.getCategoria().equals("Montagna"))
                sconto += 5;
            
            v.setSconto(sconto);
            ejb.aggiorna(v);
            
            event.fire(v);
        }catch(JMSException e){
            e.printStackTrace();
        }
    }
    
}
