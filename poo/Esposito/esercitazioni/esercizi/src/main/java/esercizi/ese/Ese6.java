/* Scrivere un programma che data una stringa s inserita a linea di comando controlla se
il primo carattere di s è ripetuto nella stringa stampando la posizione in cui è ripetuto
(oppure -1). */

package esercizi.ese;

public class Ese6 {
    public static void main(String[] args) {
        String parola=args[0].toLowerCase();
        char primo=parola.charAt(0);
        
        for(int i=0; i<parola.length(); i++){
            if(primo == parola.charAt(i)){
                System.out.println(i);
            }
        }
    }
}