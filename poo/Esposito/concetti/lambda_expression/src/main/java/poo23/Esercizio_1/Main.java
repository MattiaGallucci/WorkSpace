/* Scrivi un programma Java per implementare un'espressione lambda per trovare la somma di due numeri interi. */

package poo23.Esercizio_1;

public class Main {
    public static void main(String[] args){
        SumCalculator sumCalculator = (a, b) -> a + b;
        int result = sumCalculator.sum(1, 2);

        System.out.println("Somma 1 + 2 = " + result);
        
        result = sumCalculator.sum(5, -10);
        System.out.println("Somma 5 + (-10) = " + result);
    }
}