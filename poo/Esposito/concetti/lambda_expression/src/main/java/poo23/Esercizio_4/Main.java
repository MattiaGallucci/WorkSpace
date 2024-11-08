/* Scrivere un programma Java per implementare un'espressione lambda per filtrare i numeri pari e dispari da un elenco di numeri interi. */

package poo23.Esercizio_4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();
        for(int num: evenNumbers)
            System.out.print(num + " ");
        
        System.out.println();
        
        List<Integer> oddNumbers = numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
        for(int num: oddNumbers)
            System.out.print(num + " ");

        System.out.println();

        Map<Boolean, List<Integer>> lista = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(lista);
    }
}
