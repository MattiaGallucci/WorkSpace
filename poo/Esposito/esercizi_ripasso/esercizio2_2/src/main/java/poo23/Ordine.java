package poo23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ordine {
    private HashMap<ClienteData, List<TipologiaPiatto>> ordine;
    
    public Ordine() {
        ordine = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Ordine [ordine=" + ordine + "]";
    }

    public Cliente getCliente(){
        return ordine.keySet().iterator().next().getCliente();
    }
    
    public void aggiungiOrdine(Cliente cliente, String data, TipologiaPiatto piatto) {
        ClienteData chiave = new ClienteData(cliente, data);
        List<TipologiaPiatto> listaProdotti = ordine.computeIfAbsent(chiave, k -> new ArrayList<>());
        listaProdotti.add(piatto);
    }

    public void aggiungiOrdine(ClienteData chiave, TipologiaPiatto piatto){
        List<TipologiaPiatto> listaProdotti = ordine.computeIfAbsent(chiave, k -> new ArrayList<>());
        listaProdotti.add(piatto);

    }

    public int costoOrdine(Cliente cliente , String data){
        ClienteData chiave = new ClienteData(cliente, data);
        List<TipologiaPiatto> listaProdotti = ordine.get(chiave);
        int costo = 0;
        for(TipologiaPiatto piatto : listaProdotti){
            costo += piatto.getCosto();
        }
        return costo;
    }

    public int costoOrdine(ClienteData cliente){
        int costo = 0;
        for(TipologiaPiatto piatto : ordine.get(cliente)){
            costo += piatto.getCosto();
        }
        return costo;
    }

    public int numeroOrdiniPerCliente(Cliente cliente){
        int contatore = 0;
        for(ClienteData chiave : ordine.keySet()){
            if(chiave.getCliente().equals(cliente)){
                contatore++;
            }
        }
        return contatore;
    }

    public int puntiConseguiti(Cliente cliente){
        int punti = 0;
        for(ClienteData chiave : ordine.keySet()){
            if(chiave.getCliente().equals(cliente)){
                if(costoOrdine(chiave) >= 100)
                    punti = 30;
                else if(costoOrdine(chiave) >= 50)
                    punti = 10;
            }
        }
        return punti;
    }

    public int calcolaTotale(Cliente cliente, String data){
        ClienteData chiave = new ClienteData(cliente, data);
        List<TipologiaPiatto> lista = ordine.get(chiave);
        return lista.stream().mapToInt(TipologiaPiatto::getCosto).sum();
    }
}
