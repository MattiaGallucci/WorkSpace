public class Coppia {

    public static class Pair<T> {
        public final T one;
        public final T two;

        public Pair(T one, T two) {
            this.one = one;
            this.two = two;
        }
    }
    
    public static class Main {
        // Per avere il più piccolo tra due oggetti, devono essere confrontabili.

        public static <T extends Comparable<? super T>> T smallest(Pair<T> p) {
            if (p.one.compareTo(p.two) < 0) {
                return p.one;
            } else {
                return p.two;
            }
        }
        
        public static void main(String[] args) {
            Pair<Double> pd = new Pair<>(7.0, 6.3);
            System.out.println(smallest(pd));
            Pair<String> ps = new Pair<>("big", "small");
            System.out.println(smallest(ps));
            /* Le righe sottostanti non sono compilabili perché il colore non è comparabile
            Pair<java.awt.Color> pc = new Pair<>(java.awt.Color.BLUE, java.awt.Color.RED);
            System.out.println(smallest(ps));*/
        }
    }
}
