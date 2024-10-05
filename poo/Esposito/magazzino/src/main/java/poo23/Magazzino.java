package poo23;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Magazzino<T> {
    private HashMap<String, List<? extends T>> prodotti;
    
    public Magazzino() {
        prodotti = new HashMap<>();
    }
    
    public void aggiungi(String nome, List<? extends T>prodotto) {
        prodotti.put(nome, prodotto);
    }
    public List<? extends T> getProdotti(String nome) {
        return prodotti.get(nome);
    }

    /* metodo per rimuovere una lista */
    public void rimuovi(String nome, T prodotto) {
        List<? extends T> lista = prodotti.get(nome);
        Iterator<? extends T> it = lista.iterator();
        while (it.hasNext()) {
            Prodotto p = (Prodotto) it.next();
            if ( (p.getNome()).equals(((Prodotto) prodotto).getNome()) ) {
                it.remove();
                break;
            }
        }
    }
}