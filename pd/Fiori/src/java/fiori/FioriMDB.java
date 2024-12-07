/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fiori;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class FioriMDB implements MessageListener{
    @Inject
    FioriEJB ejb;
    
    @Inject
    Event<Fiore> event;

    @Override
    public void onMessage(Message msg) {
        try{
            MessageWrapper mw = msg.getBody(MessageWrapper.class);
            
            int id = mw.getId();
            int giacenza = mw.getGiacenza();
            
            Fiore f = ejb.trovaPerId(id);
            
            f.setGiacenza(f.getGiacenza() + giacenza);
            
            if(f.getGiacenza() < 10){
                event.fire(f);
            }
            
            ejb.aggiorna(f);
            
            System.out.println("MDB: " + f);
        
        }catch(JMSException e){
            e.printStackTrace();
        }
    }
    
}
