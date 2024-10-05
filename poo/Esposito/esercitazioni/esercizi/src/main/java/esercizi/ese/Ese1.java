/* Scrivere un programma che stampa il carattere centrale di una stringa. */

package esercizi.ese;
public class Ese1
{
    public static void main(String[] args){
        String parola1 = "MaTto";
        String parola2 = "Ciao";
        int len=0;

        len = parola1.length();
        System.out.println("La lunghezza della parola 1 è: " + len);
        System.out.println("Lettera centrale: " + parola1.substring(len/2, len/2+1));

        len = parola2.length();
        System.out.println("La lunghezza della parola 2 è: " + len);
        System.out.println("Lettera centrale: " + parola2.substring(len/2-1, len/2));
        
    }
}