package poo23;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App 
{
    /*  deve restituire le prime 10 canzoni che iniziano
        con la lettera “D”, in ordine alfabetico, pubblicate
        prima del 2000 ma senza ripetizioni. */
    albums.stream()
            .filter(album -> album.getYear() < 2000)
            .flatMap(album -> album.getSongs().stream().filter(s -> s.startsWith("D"))
            .distinct()
            .sorted()
            .limit(10)
            .forEach(System.out::println);

    /*   Consideriamo un altro esempio di un metodo che calcola l’età media dei
        membri in una raccolta: */
    Double average = roster.stream()
                           .filter(p -> p.getGender() == Person.Sex.MALE)
                           .mapToInt(Person::getAge)
                           .average()
                           .getAsDouble();

    IntStream intStream = IntStream.range(1, 10);
    DoubleStream doubleStream = new Random().doubles();
    Stream<Path> pathStream = Files.list(Paths.get("c:\\"));
    Stream<T> stringStream = Stream<T>.of(X extends T...vars); // Costruisce uno stream con i valori contenuti nel metodo .of

    /*  Ritorna uno stream di linee come
        stringhe lette da un file. */
    long uniqueWords = 0;
    try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Chrset.defaultCharset())){ 
                               uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distint().count();
    } catch(IOException e) {}
    

    /* Determinare quando continuare la generazione */
    IntStream.iterate(0, n -> n < 100, n -> n + 4).forEach(System.out::println);

    IntStream.iterate(0, n -> n + 4).takeWhile(n -> n < 100).forEach(System.out::println);

    /* OPTIONAL */
     // Senza l’uso degli Optional :
    User user = getUser(name); // può ritornare null
    Location location = null;
    if(user != null)
    location = getLocation(user);
    // Con l’uso degli Optional :
    Optional<User> user = Optional.ofNullable(getUser(user));
    Optional<Location> location = user.map(u -> getLocation(user));

    /*  Ipotizziamo di creare un nuovo tipo di dato, chiamato Averager, che contiene
        due variabili membro per tenere traccia dei due dati richiesti per il calcolo
        della media: */
    class Averager implements IntConsumer {
        private int total = 0; private int count = 0;
        public double average() {
        return count > 0 ? ((double) total)/count : 0; }
        public void accept(int i) {
        total += i; count++; }
        public void combine(Averager other) {
        total += other.total;
        count += other.count; }
    }

    Averager averageCollect = roster.stream()
                                    .filter(p -> p.getGender() == Person.Sex.MALE)
                                    .map(Person::getAge)
                                    .collect(Averager::new, Averager::accept, Averager::combine);
    System.out.println("Average age of male members: " + averageCollect.average());

    /*  In questo esempio la mappa restituita ha due chiavi: Person.Sex.MALE
        e Person.Sex.FEMALE */
    Map<Person.Sex, List<Person>> byGender =
    roster.stream().collect(Collectors.groupingBy(Person::getGender));

    
    
    Map<Boolean, List<Dish> > partitionedMenu = menu.stream().collect(partitiongBy(Dish::isVegetarian));
    //  Tale istruzione ritorna una istanza di Map del tipo:
    //  {false=[pork, beef, salmon],true=[french fries, rise, fruit] }
    //  È possibile ottenere i piatti vegetariani come
    List<Dish> vegetariaDishes = partitionedMenu.get(true);
    
}
