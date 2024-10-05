package poo23;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Crea una collezione di stringhe
        List<String> lista = new ArrayList<>();
        lista.add("Ciao");
        lista.add("Mondo");
        lista.add("Java");

        System.out.print("La collezione contiene: ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Restituisce la dimensione della collezione
        System.out.println("La dimensione della collezione è: " + lista.size());
        System.out.println();

        // Verifica se la collezione è vuota
        System.out.println("La collezione è vuota? " + lista.isEmpty());
        System.out.println();

        // Verifica se la stringa "Ciao" è presente nella collezione
        System.out.println("La stringa 'Ciao' è presente nella collezione? " + lista.contains("Ciao"));
        System.out.println();

        // Aggiunge la stringa "Python" alla collezione
        lista.add("Python");
        System.out.print("Nuova collezione aggiungendo 'Python': ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Rimuove la stringa "Mondo" dalla collezione
        lista.remove("Mondo");
        System.out.print("Nuova collezione rimuovendo 'Mondo': ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Verifica se la collezione contiene la collezione [1, 2, 3]
        List<String> listaNumeri = Arrays.asList("1", "2", "3");
        System.out.println("La collezione contiene la collezione [1, 2, 3]? " + lista.containsAll(listaNumeri));
        System.out.println();

        // Aggiunge la collezione [1, 2, 3] alla collezione
        Collections.addAll(lista, "Ciao", "Mondo");
        System.out.print("Nuova collezione aggiungendo 'Ciao' 'Mondo': ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Rimuove la collezione lista2 dalla collezione lista
        List<String> lista2 = Arrays.asList("Ciao", "Mondo");
        lista.removeAll(lista2);
        System.out.print("Nuova collezione rimuovendo lista2 ['Ciao' 'Mondo']: ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Mantiene nella collezione solo gli elementi che sono anche nella collezione lista3
        List<String> lista3 = Arrays.asList("Java");
        lista.retainAll(lista3);
        System.out.print("Nuova collezione rimuovendo tutto tranne che 'Java': ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Elimina tutti gli elementi dalla collezione
        lista.clear();
        System.out.print("Eliminazione di tutti gli elementi dalla collezione: ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Restituisce gli elementi della collezione come un array
        // Object[] array = lista.toArray();

        System.out.println("Creazione lista ['Ciao' 'Mondo' 'Java']");
        lista.add("Ciao");
        lista.add("Mondo");
        lista.add("Java");
        System.out.println();

        // Fornisce un iteratore alla collezione
        System.out.print("Visualizzazione della lista: ");
        Iterator<String> iteratore = lista.iterator();
        while (iteratore.hasNext()) {
            System.out.print(iteratore.next() + " ");
        }
        System.out.println();
        System.out.println();

        // Aggiunge gli elementi "Python" e "Java" alla collezione
        lista.addAll(Arrays.asList("Python", "Java"));
        System.out.print("Nuova collezione aggiungendo 'Python' 'Java': ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Ricerca la stringa "Python" nella collezione
        int posizione = Collections.binarySearch(lista, "Python");
        if (posizione >= 0) {
            System.out.println("La stringa 'Python' è presente nella posizione: " + posizione);
        } else {
            System.out.println("La stringa 'Python' non è presente nella collezione");
        }
        System.out.println();

        // Copia gli elementi della lista [1, 2, 3] nella lista lista
        Collections.copy(listaNumeri, Arrays.asList("1", "2", "3"));

        // Verifica che le due collezioni lista e listaNumeri non abbiano elementi in comune
        System.out.println("Le due collezioni lista e listaNumeri non hanno elementi in comune? " + Collections.disjoint(lista, listaNumeri));
        System.out.println();

        // Sostituisce tutti gli elementi della lista con la stringa "Hello"
        Collections.fill(lista, "Hello");
        System.out.print("Nuova collezione sostituendo tutto con 'Hello': ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Conta le occorrenze della stringa "Java" nella collezione
        int occorrenze = Collections.frequency(lista, "Java");
        System.out.println("La stringa 'Java' è presente nella collezione " + occorrenze + " volte");
        System.out.println();

        // Restituisce il valore massimo nella collezione
        Object massimo = Collections.max(lista);
        System.out.println("Il valore massimo nella collezione è: " + massimo);
        System.out.println();

        // Sostituisce la stringa "Python" con la stringa "C++" nella collezione
        lista.add("Python");
        System.out.print("Nuova collezione aggiungendo 'Python': ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        Collections.replaceAll(lista, "Python", "C++");
        System.out.print("Nuova collezione sostituendo 'Python' con 'C++': ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Inverte l'ordine degli elementi nella collezione
        Collections.reverse(lista);
        System.out.print("Nuova collezione con ordine invertito: ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Ordina gli elementi nella collezione
        Collections.sort(lista);
        System.out.print("Nuova collezione ordinata: ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();

        // Scambia di posto gli elementi di posizione 0 e 1 nella collezione
        Collections.swap(lista, 0, 1);
        System.out.print("Nuova collezione sostituendo la parola in posizione 0 con la parola in posizione 1: ");
        for(String s : lista)
            System.out.print(s + " ");
        System.out.println();
        System.out.println();
    }
}
