/* Scrivi un programma Java per implementare un'espressione lambda per convertire un numero intero nella corrispondente rappresentazione binaria. */

package poo23.Esercizio_7;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        int n = 33;

        Function<Integer, String> convertToBinary = num -> Integer.toBinaryString(num);
        
        String binary = convertToBinary.apply(n);
        System.out.println("Rappresentazione binaria: " + binary);
    }
}
