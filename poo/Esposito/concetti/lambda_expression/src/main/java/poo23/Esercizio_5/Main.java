/* Scrivere un programma Java per implementare un'espressione lambda per ordinare un elenco di stringhe in ordine alfabetico. */

package poo23.Esercizio_5;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("casa", "auto", "bici", "pallone");
        
        list.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

        for(String s : list)
            System.out.println(s);
    }
}
