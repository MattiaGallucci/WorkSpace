/* Scrivere un programma che istanzi un oggetto Rectangle e lo stampi. Poi, modificare il
programma in modo che sposti il rettangolo stampato prima e lo stampi per altre 3
volte in modo che, se i 4 rettangoli stampati fossero disegnati, formerebbero un unico
grande rettangolo */

package esercizi.ese;

public class Ese7 {
    public static void main(String[] args) {
        int base=7, altezza=9, area;

        area = base * altezza;
        System.out.println("Area del rettangolo è: " + area);

        for(int i=0; i<altezza; i++){
            for(int j=0; j<base; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for(int i=0; i<altezza*2; i++){
            for(int j=0; j<base*2; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

/* //! INTERATTIVO
import java.util.Scanner;
public class Ese7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Inserire base: ");
        int base = sc.nextInt();
        
        System.out.println("Inserire altezza: ");
        int altezza = sc.nextInt();
        
        sc.close();
        
        System.out.println("L'area del rettangolo è " + (base * altezza)+" mq");
    } // fine metodo main
}
*/