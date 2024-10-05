/* Scrivi un programma Java per implementare un'espressione lambda per verificare se una determinata stringa è vuota. */

package poo23.Esercizio_2;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> isEmptyString = str -> str.isEmpty();

        String str1 = "", str2 = "Hello World";
        System.out.println("String 1: " + str1);
        System.out.println("String 1 is empty: " + isEmptyString.test(str1));
        System.out.println("String 2: " + str2);
        System.out.println("String 2 is empty: " + isEmptyString.test(str2));
    }
}
