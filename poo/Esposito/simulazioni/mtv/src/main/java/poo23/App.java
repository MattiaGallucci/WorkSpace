package poo23;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args ) throws GenereMismatchException
    {
        Classifica<Singolo> classifica = new Classifica<>("Top10", AreaGeografica.UK, Genere.TRAP);
        Classifica<Disco> classificaDisco = new Classifica<>("Top10", AreaGeografica.UK, Genere.TRAP);
        // Disco disco1 = new Disco("D1", "IO", 2000, "POO", Genere.TRAP, 10);
        // Singolo singolo1 = new Singolo("Prova", 1, "Io", Genere.POP, disco1);
        // Singolo singolo2 = new Singolo("Prova2", 1, "Io", Genere.TRAP, disco1);
        // Singolo singolo3 = new Singolo("Prova3", 2000, "Io", Genere.POP, disco1);
        // Singolo singolo4 = new Singolo("Prova4", 1, "Io", Genere.TRAP, disco1);
        // Singolo singolo5 = new Singolo("Prova5", 1, "Io", Genere.POP, disco1);
        // System.out.println(disco1);
        
        /*
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("mtv\\src\\main\\java\\poo23\\output.txt"))) {
            // Converti il risultato in una rappresentazione di stringa e scrivilo nel file
            String stringaDaScrivere = classifica.toString();
            writer.write(stringaDaScrivere);

            System.out.println("Risultato scritto con successo nel file.");
        } catch (IOException e) {
            // Gestisci l'eccezione in caso di errore di scrittura
            e.printStackTrace();
        }
        */
        // Disco discoDaTastiera = leggiDiscoDaTastiera();
        // System.out.println("Disco letto da tastiera: " + discoDaTastiera);

        Disco disco1 = new Disco("D1", "IO", 2020, null, Genere.TRAP, 0);
        Disco disco2 = new Disco("D2", "IO", 2023, null, Genere.TRAP, 0);
        Disco disco3 = new Disco("D3", "IO", 2019, null, Genere.TRAP, 0);
        Disco disco4 = new Disco("D4", "IO", 2023, null, Genere.TRAP, 0);
        Disco disco5 = new Disco("D5", "IO", 2017, null, Genere.TRAP, 0);
        classificaDisco.aggiungi(disco1, disco2, disco3, disco4, disco5);

        List<Disco> classificaOrdinata = classificaDisco.getClassifica().stream()
                .sorted(Comparator.comparing(Disco::getAnno)
                .thenComparing(Disco::getTitolo))
                .collect(Collectors.toList());
        System.out.println(classificaOrdinata);
    }

    public static Disco leggiDiscoDaTastiera() {
        System.out.println("Inserisci i dettagli del disco:");

        // Creazione di uno StreamTokenizer per leggere da input
        StreamTokenizer tokenizer = creaStreamTokenizer(System.in);

        try {
            // Leggi i campi del disco utilizzando lo StreamTokenizer
            String titolo = leggiToken(tokenizer);
            String casaDiscografica = leggiToken(tokenizer);
            int anno = leggiNumero(tokenizer);
            String artista = leggiToken(tokenizer);
            String genere = leggiToken(tokenizer);
            int numeroCanzoni = leggiNumero(tokenizer);

            // Crea e restituisci un nuovo oggetto Disco
            return new Disco(titolo, casaDiscografica, anno, artista, Genere.valueOf(genere.toUpperCase()), numeroCanzoni);
        } catch (IOException e) {
            // Gestione dell'eccezione di IO
            e.printStackTrace();
            return null;
        }
    }

    private static StreamTokenizer creaStreamTokenizer(InputStream inputStream) {
        // Creazione di uno StreamTokenizer con InputStreamReader
        Reader reader = new InputStreamReader(inputStream);
        return new StreamTokenizer(reader);
    }

    private static String leggiToken(StreamTokenizer tokenizer) throws IOException {
        // Leggi una parola (token) dallo StreamTokenizer
        tokenizer.nextToken();
        if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
            return tokenizer.sval;
        } else {
            throw new IOException("Token non valido");
        }
    }

    private static int leggiNumero(StreamTokenizer tokenizer) throws IOException {
        // Leggi un numero dallo StreamTokenizer
        tokenizer.nextToken();
        if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
            return (int) tokenizer.nval;
        } else {
            throw new IOException("Numero non valido");
        }
    }
}
