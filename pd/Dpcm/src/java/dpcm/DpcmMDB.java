/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpcm;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class DpcmMDB implements MessageListener{
    @Inject
    DpcmEJB ejb;
    
    @Inject
    Event<Dpcm> event;

    @Override
    public void onMessage(Message msg){
	try{
            MessageWrapper mw = msg.getBody(MessageWrapper.class);
            int id = mw.getId();
            int stampa = mw.getStampa();
            
            Dpcm d = ejb.trovaPerId(id);
            
            d.setStampa(d.getStampa()+stampa);
            ejb.aggiorna(d);
            event.fire(d);
        }catch(JMSException e){
            e.printStackTrace();
        }
    }
}