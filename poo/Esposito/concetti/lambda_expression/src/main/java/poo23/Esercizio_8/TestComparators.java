/*  Creare una classe TestComparators contenente un metodo main che dichiara un array di stringhe
    (di cui almeno due con la stessa lunghezza). Creare degli oggetti Comparator con espressioni
    lambda, per produrre ordinamenti secondo i seguenti criteri:
        in ordine di lunghezza (dalla stringa più lunga alla più breve);
        in ordine di lunghezza al contrario (dalla stringa più breve alla più lunga);
        in ordine alfabetico (usare comunque un'espressione lambda o un reference a metodo, anche se non ce ne sarebbe bisogno);
        in ordine alfabetico inverso;
        in ordine di lunghezza e in caso di stessa lunghezza in ordine alfabetico.
   
    Ordinare l'array mediante il metodo sort della classe Arrays, che prende in input come primo
    parametro l'array dichiarato e come secondo parametro un oggetto di tipo Comparator. Dopo
    ogni ordinamento stampare il risultato. */

package poo23.Esercizio_8;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparators {
    static String nomi[] = {"Clarissa", "Jem", "Top", "Ermeringildo", "Iamaca", "Tom", "Arlequin", "Francesca", "Cumbus", "Blue"};
    public static void main(String args[]) {
        Comparator<String> comparatorLunghezza = (first, second) -> -(Integer.compare(first.length(), second.length()));
        Comparator<String> comparatorLunghezzaAlContrario = (first, second) -> (Integer.compare(first.length(), second.length()));
        Comparator<String> comparatorAlfabeticoAlContrario = (first, second) -> (first.compareTo(second));
        Comparator<String> comparatorLunghezzaEAlfabeticoAlContrario = (first, second) -> {
            int result = -Integer.compare(first.length(), second.length());
            if (result == 0) 
                result = first.compareTo(second);
            return result;
        };

        Arrays.sort(nomi, comparatorLunghezza);
        System.out.println("Nomi ordinati per lunghezza: " + Arrays.asList(nomi));
        Arrays.sort(nomi, comparatorLunghezzaAlContrario);
        System.out.println("Nomi ordinati per lunghezza al contrario: " + Arrays.asList(nomi));
        Arrays.sort(nomi, String::compareTo);
        System.out.println("Nomi ordinati: " + Arrays.asList(nomi));
        Arrays.sort(nomi, comparatorAlfabeticoAlContrario);
        System.out.println("Nomi ordinati al contrario: " + Arrays.asList(nomi));
        Arrays.sort(nomi, comparatorLunghezzaEAlfabeticoAlContrario);
        System.out.println("Nomi ordinati per lunghezza al contrario e in ordine alfabetico: " + Arrays.asList(nomi));
    }
}