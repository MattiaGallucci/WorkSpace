package poo23;

import java.util.ArrayList;
import java.util.List;

public class Ristorante {
    List<Ordine> ordini;

    public Ristorante() {
        ordini = new ArrayList<>();
    }

    public void aggiungiOrdine(Ordine o) {
        ordini.add(o);
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }
    
    
}
