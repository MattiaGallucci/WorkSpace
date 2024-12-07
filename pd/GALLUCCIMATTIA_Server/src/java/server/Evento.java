package server;

import javax.enterprise.event.Observes;

public class Evento {

    public void notifica(@Observes Prenotazione p) {
        System.out.println("Nuova prenotazione per un tavolo VIP, dal cliente " + p.getNomeCliente() + " alle ore " + p.getDataTempo());
    }
}
