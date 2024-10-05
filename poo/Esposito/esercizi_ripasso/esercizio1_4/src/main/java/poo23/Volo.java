package poo23;

import java.util.HashSet;

public class Volo {
    private HashSet<RottaAerea> voli;

    public Volo(){
        voli = new HashSet<>();
    }

    public void aggiungiRotta(RottaAerea r){
        voli.add(r);
    }

    public HashSet<RottaAerea> getVoli(){
        return voli;
    }
}
