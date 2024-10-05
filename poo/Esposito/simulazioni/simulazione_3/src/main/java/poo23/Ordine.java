package poo23;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ordine implements Iterable<Capi>{
    private List<Capi> ordine;
    private boolean statoOrdine;

    public Ordine() {
        ordine = new ArrayList<Capi>();
        statoOrdine = false;
    }

    public Iterator<Capi> iterator() {
        // Implementa l'iteratore per la classe base
        // Puoi restituire un iteratore vuoto o implementare un'iterazione personalizzata se necessario
        return new Iterator<Capi>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Capi next() {
                return null;
            }
        };
    }
    
    public void setStatoOrdine(boolean statoOrdine) { this.statoOrdine = statoOrdine; }
    public boolean getStatoOrdine() { return statoOrdine; }
    
    public void aggiungiCapi(int id) {
        Capi capo = new Capi(id, null, null, 0);
        ordine.add(capo);
    }
}