package poo23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Magazzino {
    HashMap<Prodotto, Integer> magazzino;
    List<Ordine> ordini;
    List<Ordine> prenotazioni;

    public Magazzino(){
        magazzino = new HashMap<>();
        ordini = new ArrayList<>();
        prenotazioni = new ArrayList<>();
    }

    public int getQuantita(Prodotto p){
        return magazzino.get(p);
    }

    public HashMap<Prodotto, Integer> getMagazzino() {
        return magazzino;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public List<Ordine> getPrenotazioni() {
        return prenotazioni;
    }

    public void aggiungi(Prodotto p, int quantita){
        if(magazzino.containsKey(p)){
            int q = magazzino.get(p);
            magazzino.put(p, q+quantita);
        } else {
            magazzino.put(p, quantita);
        }
    }


    public void aggiungiOrdine(Ordine o){
        ordini.add(o);
    }
}
