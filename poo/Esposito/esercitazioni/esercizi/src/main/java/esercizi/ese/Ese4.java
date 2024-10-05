/* Scrivere un programma che data una stringa inserita a linea di comando restituisce il
carattere centrale. */

package esercizi.ese;

public class Ese4 {
    public static void main(String[] args) {
        String parola = args[0];

        System.out.println(parola.charAt(parola.length()/2));
    }
}
