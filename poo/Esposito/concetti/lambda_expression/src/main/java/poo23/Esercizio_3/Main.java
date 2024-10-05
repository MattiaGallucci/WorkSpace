/* Scrivere un programma Java per implementare un'espressione lambda per convertire un elenco di stringhe in maiuscolo e minuscolo. */

package poo23.Esercizio_3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Red", "Blue", "Yellow");

        stringList.replaceAll(str -> str.toUpperCase());
        for(String str : stringList)
            System.out.println(str);
        
        stringList.replaceAll(str -> str.toLowerCase());
        for(String str : stringList)
            System.out.println(str);
    }
}
