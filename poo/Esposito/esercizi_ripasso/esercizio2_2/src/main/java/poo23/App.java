package poo23;

//import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
        Ristorante ristorante = new Ristorante();

        TipologiaPiatto antipasto = TipologiaPiatto.ANTIPASTO;
        TipologiaPiatto primo = TipologiaPiatto.PRIMO;
        TipologiaPiatto secondo = TipologiaPiatto.SECONDO;

        Cliente cliente1 = new Cliente("Mattia", "Gallucci", "Salerno");
        Cliente cliente2 = new Cliente("Carolina", "Ingino", "Salerno");
        Cliente cliente3 = new Cliente("Giulio", "Gallucci", "Solofra");
        Cliente cliente4 = new Cliente("Giulio", "Carlo", "Solofra");

        Ordine ordine1 = new Ordine();
        Ordine ordine2 = new Ordine();
        Ordine ordine3 = new Ordine();
        Ordine ordine4 = new Ordine();
        Ordine ordine5 = new Ordine();

        ordine1.aggiungiOrdine(cliente1, "1", primo);
        ordine1.aggiungiOrdine(cliente1, "1", secondo);
        ordine1.aggiungiOrdine(cliente1, "1", primo);
        ordine1.aggiungiOrdine(cliente1, "1", secondo);
        ordine1.aggiungiOrdine(cliente1, "1", secondo);
        ristorante.aggiungiOrdine(ordine1);

        ordine3.aggiungiOrdine(cliente2, "2", primo);
        ordine3.aggiungiOrdine(cliente2, "2", antipasto);
        ristorante.aggiungiOrdine(ordine3);

        ordine4.aggiungiOrdine(cliente3, "1", primo);
        ristorante.aggiungiOrdine(ordine4);

        ordine2.aggiungiOrdine(cliente1, "3", primo);
        ordine2.aggiungiOrdine(cliente1, "3", secondo);
        ristorante.aggiungiOrdine(ordine2);

        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ordine5.aggiungiOrdine(cliente4, "1", primo);
        ristorante.aggiungiOrdine(ordine5);

        /*System.out.println("Costo ordine cliente 1 in data 1: " + ordini.costoOrdine(cliente1, "1") + " con " + ordini.puntiConseguiti(cliente1) + " punti totali");
        System.out.println("Costo ordine cliente 1 in data 3: " + ordini.costoOrdine(cliente1, "3") + " con " + ordini.puntiConseguiti(cliente1) + " punti totali");
        System.out.println("Costo ordine cliente 2 in data 2: " + ordini.costoOrdine(cliente2, "2") + " con " + ordini.puntiConseguiti(cliente2) + " punti totali");
        System.out.println("Costo ordine cliente 3 in data 1: " + ordini.costoOrdine(cliente3, "1") + " con " + ordini.puntiConseguiti(cliente3) + " punti totali");
        System.out.println("Costo ordine cliente 4 in data 1: " + ordini.costoOrdine(cliente4, "1") + " con " + ordini.puntiConseguiti(cliente4) + " punti totali");
        System.out.println();

        System.out.println("Ordini effettuati da cliente 1: " + ordini.numeroOrdiniPerCliente(cliente1));
        System.out.println();*/

        long occorenzeCliente1 = ristorante.getOrdini().stream()
        .filter(ordine -> ordine.getCliente().equals(cliente1))
        .count();
        System.out.println("Numero ordini cliente1: " + occorenzeCliente1);

    }
}
