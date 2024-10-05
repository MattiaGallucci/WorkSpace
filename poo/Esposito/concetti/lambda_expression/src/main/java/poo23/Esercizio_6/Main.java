/* Scrivi un'espressione lambda per implementare un'espressione lambda per calcolare il fattoriale di un determinato numero. */

package poo23.Esercizio_6;

import java.util.function.LongUnaryOperator;

public class Main {
    public static void main(String[] args) {
        LongUnaryOperator fattoriale = x -> {
            long result = 1;
            for (long i = 1; i <= x; i++) {
                result *= i;
            }
            return result;
        };

        long n = 7;
        long f = fattoriale.applyAsLong(n);
        System.out.println("Il fattoriale di " + n + " è " + f);
    }
}
