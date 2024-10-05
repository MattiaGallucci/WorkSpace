package poo23;

import java.util.Comparator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.List;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
        Ristorante ristorante = new Ristorante();

        Menu menu = new Menu();
        Primo primo1 = new Primo("1a", "pasta e sugo", 10.00);
        Primo primo2 = new Primo("1b", "pasta e patate", 7.00);
        Primo primo3 = new Primo("1c", "pasta e vongole", 15.00);
        Secondo secondo1 = new Secondo("2a", "carne", 12.00);
        Secondo secondo2 = new Secondo("2b", "pollo", 8.00);
        Secondo secondo3 = new Secondo("2c", "tacchino", 10.00);
        Bevanda bevanda1 = new Bevanda("3a", "acqua", 1.50);
        Bevanda bevanda2 = new Bevanda("3b", "sprite", 2.00);
        menu.aggiungiPrimo(primo1, primo2, primo3);
        menu.aggiungiSecondi(secondo1, secondo2, secondo3);
        menu.aggiungiBevande(bevanda1, bevanda2);

        Tavolo tavolo1 = new Tavolo(TipologiaLuogo.ESTERNO, 1, 1);
        tavolo1.aggiungiPrimo(primo1);
        tavolo1.aggiungiSecondo(secondo1, secondo2);
        tavolo1.aggiungiBevanda(bevanda1);
        ristorante.aggiungiTavolo(tavolo1);

        // System.out.println(menu);
        double contoTavolo1 = tavolo1.calcoloConto();
        System.out.println("Conto tavolo 1: " + contoTavolo1);
        
        // 2    ESERCIZIO
        Bevanda bevandaDaTastiera = leggiBevandaDaTastiera();
        System.out.println("Bevanda letta da tastiera: " + bevandaDaTastiera);
        menu.aggiungiBevande(bevandaDaTastiera);
        // System.out.println(menu);

        // 3    ESERCIZIO
        Tavolo tavolo2 = new Tavolo(TipologiaLuogo.ESTERNO, 2, 2);
        tavolo2.aggiungiPrimo(primo1);
        tavolo2.aggiungiSecondo(secondo1);
        
        Tavolo tavolo3 = new Tavolo(TipologiaLuogo.VIP, 3, 5);
        tavolo3.aggiungiPrimo(primo1, primo2, primo3, primo1, primo1);
        tavolo3.aggiungiSecondo(secondo1, secondo1, secondo1, secondo1, secondo1);
        tavolo3.aggiungiBevanda(bevanda1, bevanda1, bevanda1, bevanda1, bevanda1);

        ristorante.aggiungiTavolo(tavolo2, tavolo3);

        List<Tavolo> tavoliOrdinati = ristorante.getTavoli();
        tavoliOrdinati.sort(Comparator.comparingDouble(Tavolo::calcoloConto));
        // System.out.println("Tavoli ordinati per conto in modo crescente: " + tavoliOrdinati);

        // CON STREAM
        List<Tavolo> tavoliOrdinati2 = ristorante.getTavoli().stream()
                .sorted(Comparator.comparing(Tavolo::calcoloConto))
                .collect(Collectors.toList());
        // System.out.println("Tavoli ordinati per conto in modo crescente: " + tavoliOrdinati2);

        List<Tavolo> tavoliOrdinatiPerCoperti = ristorante.getTavoli().stream()
                .sorted(Comparator.comparing(Tavolo::getCoperto)
                        .thenComparing(tavolo -> tavolo.getBevandeConsumate().size()))
                .collect(Collectors.toList());
        // System.out.println("Tavoli ordinati per numero di coperti: " + tavoliOrdinatiPerCoperti);

        //! NON SVOLTO
        /*List<Tavolo> tavoliOrdinatiPerConto = ristorante.getTavoli().stream()
        .sorted(Comparator.comparing(Tavolo::calcoloConto)
                .thenComparing(tavolo -> tavolo.getBevandeConsumate().size()))
        .collect(Collectors.toList());
        System.out.println("\n\nTavoli ordinati per conto in modo crescente: " + tavoliOrdinatiPerConto);*/

        // 4    ESERCIZIO
        long tavoliEsterni20Euro = ristorante.getTavoli().stream()
                .filter(tavolo -> tavolo.getLuogo() == TipologiaLuogo.ESTERNO && tavolo.calcoloConto() >= 20)
                .count();
        //System.out.println("Tavoli con conto superiore a 20 euro sitauti all'esterno: " + tavoliEsterni20Euro);

    }

    public static Bevanda leggiBevandaDaTastiera() {
        System.out.println("Inserisci i dettagli della bevanda:");

        StreamTokenizer tokenizer = creaStreamTokenizer(System.in);
        // tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        try {
            System.out.println("Id:");
            String id = leggiToken(tokenizer);
            System.out.println("Descrizione:");
            String descrizione = leggiToken(tokenizer);
            System.out.println("Prezzo:");
            double prezzo = leggiNumero(tokenizer);
            
            return new Bevanda(id, descrizione, prezzo);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static StreamTokenizer creaStreamTokenizer(InputStream inputStream) {
        Reader reader = new InputStreamReader(inputStream);
        return new StreamTokenizer(reader);
    }

    private static String leggiToken(StreamTokenizer tokenizer) throws IOException {
        tokenizer.nextToken();
        if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
            return tokenizer.sval;
        } else {
            throw new IOException("Token non valido");
        }
    }

    private static int leggiNumero(StreamTokenizer tokenizer) throws IOException {
        tokenizer.nextToken();
        if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
            return (int) tokenizer.nval;
        } else {
            throw new IOException("Numero non valido");
        }
    }
}
