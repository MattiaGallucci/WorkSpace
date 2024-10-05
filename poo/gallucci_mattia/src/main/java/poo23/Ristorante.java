package poo23;

import java.util.ArrayList;
import java.util.List;

public class Ristorante {
    List<Tavolo> tavoli;

    public Ristorante() {
        tavoli = new ArrayList<>();
    }

    public List<Tavolo> getTavoli() {
        return tavoli;
    }

    public void setTavoli(List<Tavolo> tavoli) {
        this.tavoli = tavoli;
    }
    
    public void aggiungiTavolo(Tavolo ... tavolo) {
        for(Tavolo tavolo1 : tavolo)
            tavoli.add(tavolo1);
    }

    @Override
    public String toString() {
        return "Ristorante [tavoli=" + tavoli + "]";
    }
    
}
