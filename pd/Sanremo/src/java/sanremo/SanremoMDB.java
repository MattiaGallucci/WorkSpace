/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sanremo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class SanremoMDB implements MessageListener{
    
    @Inject
    SanremoEJB ejb;
    
    @Inject
    Event<Canzone> generalEvent;
    
    @Inject @Morgan
    Event<Canzone> morganEvent;

    @Override
    public void onMessage(Message msg) {
        try {
            MessageWrapper mw = msg.getBody(MessageWrapper.class);
            int id = mw.getId();
            String cantante = mw.getCantante();
            String parole = mw.getParole();
            
            Canzone c = ejb.printById(id);
            
            if(c.getIncipit().equals(parole)){
                c.setCantato(true);
                
                if(cantante.equals("Bugo e Morgan")){
                    c.setTitolo("Morgan");
                    morganEvent.fire(c);
                } else
                    generalEvent.fire(c);
            }
            
            ejb.aggiorna(c);
            System.out.println("MDB: " + c);
        } catch (JMSException ex) {
            Logger.getLogger(SanremoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
