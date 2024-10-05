package poo23;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class App 
{
    public static void main( String[] args )
    {
        Magazzino magazzino = new Magazzino();
        Prodotto libro = new Prodotto(TipologiaProdotto.LIBRO, "Libro", 20);
        Prodotto quaderno = new Prodotto(TipologiaProdotto.QUADERNO, "Quaderno", 5);
        magazzino.aggiungi(libro, 20);
        magazzino.aggiungi(quaderno, 5);

        Cliente cliente1 = new Cliente("1A");

        Ordine ordine1 = new Ordine("Ordine1", cliente1, libro, 5);
        Ordine ordine2 = new Ordine("Ordine2", cliente1, quaderno, 10);

        magazzino.aggiungiOrdine(ordine1);
        magazzino.aggiungiOrdine(ordine2);

        List<Ordine> ordiniPossibili = magazzino.getOrdini().stream()
        .filter(o -> o.getQuantita() < o.getProdottoOrdinato().getQuantita())
        .collect(toList());

        long prodottiDaPrenotare = magazzino.getOrdini().stream()
        .filter(o -> o.getQuantita() > o.getProdottoOrdinato().getQuantita())
        .mapToLong(o -> o.getQuantita() - o.getProdottoOrdinato().getQuantita())
        .sum();

        System.out.println("Ordini possibili: " + ordiniPossibili);
        System.out.println("Prodotti da prenotare: " + prodottiDaPrenotare);
    }
}
