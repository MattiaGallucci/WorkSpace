/* Scrivere un programma che data una stringa s1s2 costante di almeno 2 caratteri,
costruisce la seguente stringa s2s1,
che viene poi stampata a video. */

package esercizi.ese;

public class Ese3 {
    public static void main(String[] args) {
        String parola = args[0]; //Run&Degub -> create a lunch.json file -> trovare progetto -> aggiungere virgola a ultima riga e "args": "stringa"
        int len = parola.length();
        System.out.println(parola.substring(len/2, len) + parola.substring(0, len/2));
    }
}
