package poo23;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Magazzino<T> {
    private HashMap<String, List<? extends T>> prodotti;
    public Magazzino() {
        prodotti = new HashMap<>();
    }
    public void aggiungi(String nome, List<? extends T>prodotto) { prodotti.put(nome, prodotto); }
    public List<? extends T> getProdotti(String nome) { return prodotti.get(nome); }

    public void diminuisciQuantitaInMagazzino(String nome, int id){
        List<? extends T> prod = prodotti.get(nome);
        Iterator<? extends T> it = prod.iterator();
        while(it.hasNext()){
            Capi p = (Capi) it.next();
            if( (p.getId() == id) ){
                p.diminuisciQuantita();
                break;
            }
        }
    }
}