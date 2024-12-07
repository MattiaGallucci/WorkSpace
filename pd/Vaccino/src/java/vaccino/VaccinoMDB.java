/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vaccino;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/javaee7/Topic")
public class VaccinoMDB implements MessageListener{
    @Inject
    VaccinoEJB ejb;
    
    @Inject
    Event<Individuo> generalEvent;
    
    @Inject @Pensionato
    Event<Individuo> pensionatoEvent;

    @Override
    public void onMessage(Message msg) {
        try{
            MessageWrapper mw = msg.getBody(MessageWrapper.class);
            
            int id = mw.getId();
            boolean interesse = mw.isInteressatoVaccino();
            
            Individuo i = ejb.trovaPerId(id);
            
            i.setInteressatoVaccino(interesse);
            ejb.aggiornaIndividuo(i);
            
            generalEvent.fire(i);
            
            if(interesse && i.getCateogria().equals(Categoria.PENSIONATO)){
                pensionatoEvent.fire(i);
            }
            
            if(i.getMalattiePregresse() > 2){
                if(i.getPriorita().equals(Priorita.BASSA))
                    i.setPriorita(Priorita.MEDIA);
                else if(i.getPriorita().equals(Priorita.MEDIA))
                    i.setPriorita(Priorita.ALTA);
            }
            ejb.aggiornaIndividuo(i);
        } catch (JMSException ex) {
            Logger.getLogger(VaccinoMDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
