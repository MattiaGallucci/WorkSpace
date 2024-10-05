package poo23;

import java.util.Iterator;

public class Polynomial implements Iterable<Pair<Integer, Double>>{
    private Double[] coefficienti;

    public Polynomial(Double[] coefficienti) {
        this.coefficienti = coefficienti;
    }
    
    @Override
    public Iterator<Pair<Integer, Double>> iterator() {
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

    // esempio: 1.0 + 2.0 x^1 + ...
    /*public String toString() {
        String espressione="";
        int esponente = 0;
        for (int i = 0; i < coefficienti.length; i++) {

        }
    } */
}
