package server;

import java.util.HashMap;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Counter
public class CounterInterceptor {
    private HashMap<String, Integer> hm = new HashMap<>();
    @Inject
    Event<Prenotazione> evento;
    
    @AroundInvoke
    public Object count(InvocationContext ic) throws Exception { //da InitialContext a InvocationContext e aggiunta throws Exception
        String metodo = ic.getMethod().getName();
        if (!(hm.containsKey(metodo))) { //da hm.contains(metodo) a hm.containsKey(metodo)
            hm.put(metodo, 1);
        } else {
            hm.put(metodo, hm.get(metodo) + 1);
        }
        System.out.println("Metodo: " + metodo + ", numero di volte chiamato: " + hm.get(metodo));

        if (metodo.equals("crea")) {
            Prenotazione p = (Prenotazione) ic.getParameters()[0];
            if (p.getTipoTavolo().equals("VIP")) {
                evento.fire(p);
            }
        }
        return ic.proceed();
    }
}