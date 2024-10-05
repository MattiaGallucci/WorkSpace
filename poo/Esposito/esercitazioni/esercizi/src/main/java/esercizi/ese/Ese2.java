/* Scrivere un programma che data una stringa di almeno 2 caratteri, ne costruisce
un’altra dove il primo carattere è scambiato con l’ultimo, che viene poi stampata a
video. */

package esercizi.ese;

public class Ese2 {
    public static void main(String[] args) {
        String parola1 = "Mattia";

        if(parola1.length() < 2)
            return;
        else{
            System.out.println(parola1.charAt(parola1.length()-1) + parola1.substring(1, parola1.length()-1) + parola1.charAt(0));
        }
    }
}
