/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uefa;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class PartitaMDB implements MessageListener{

    @Inject
    PartitaEJB ejb;
    
    @Inject
    Event<Partita> event;
    @Inject @Italia
    Event<Partita> eventItalia;
    
    @Override
    public void onMessage(Message msg) {
        try{
            MessageWrapper mw = msg.getBody(MessageWrapper.class);
            
            int id = mw.getId();
            int numeroGoal = mw.getNumeroGoal();
            String squadra = mw.getSquadra();
            
            Partita p = ejb.trovaPerId(id);
            
            if(p.getSquadraCasa().equals(squadra)){
                p.setGoalSquadraCasa(p.getGoalSquadraCasa() + numeroGoal);
            } else if(p.getSquadraOspite().equals(squadra)){
                p.setGoalSquadraOspite(p.getGoalSquadraOspite() + 1);
            }
            ejb.aggiornaPartita(p);
            
            if(squadra.equals("Italia"))
                eventItalia.fire(p);
            else
                event.fire(p);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
