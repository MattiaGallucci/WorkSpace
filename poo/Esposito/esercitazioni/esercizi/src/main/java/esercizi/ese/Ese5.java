/* Scrivere un programma che date tre stringhe inserite a linea di comando visualizza la
concatenazione delle loro iniziali. */

package esercizi.ese;

public class Ese5 {
    public static void main(String[] args) {

        String parola1 = args[0];
        String parola2 = args[1];
        String parola3 = args[2];
        String parola4 = "";

        parola4 = parola4.concat(parola1.substring(0,1) + parola2.substring(0,1) + parola3.substring(0,1) );
        System.out.println(parola4);

    }
}
