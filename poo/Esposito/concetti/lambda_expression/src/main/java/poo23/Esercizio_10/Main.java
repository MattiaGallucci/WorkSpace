/* Data una lista di studenti
   Stampare il nome e cognome di quelli con una media maggiore di 27;
   Ottenere la media di tutti gli studenti */

package poo23.Esercizio_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Studente> lista = new ArrayList<>();
        List<Integer> voti = new ArrayList<>();
        voti.add(25);
        voti.add(22);
        voti.add(23);
        lista.add(new Studente("Gianni", "Rossi", Arrays.asList(22, 20, 19)));
        lista.add(new Studente("Giulio", "Verdi", Arrays.asList(27, 27, 27)));
        lista.add(new Studente("Giuseppe", "Bianchi", Arrays.asList(28, 29, 30)));
        lista.add(new Studente("Giuseppe", "Verdi", Arrays.asList(25, 27, 27)));
        lista.add(new Studente("Giuseppe", "Rossi", Arrays.asList(22, 20, 19)));

        List<Studente> listafiltrata = lista.stream().filter(v -> v.getVoti().stream().mapToInt(Integer::intValue).average().getAsDouble() >= 27).collect(Collectors.toList());
        System.out.println(listafiltrata);

        // lista.stream().filter(s -> s.getVoti().stream().mapToInt(Integer::intValue).average().getAsDouble() > 27).map(s-> s.getNome() + " " + s.getCognome()).forEach(System.out::println);
        // lista.stream().mapToInt(s -> s.getVoti().stream().mapToInt(Integer::intValue).average().getAsInt()).average().getAsDouble();
        }
}
