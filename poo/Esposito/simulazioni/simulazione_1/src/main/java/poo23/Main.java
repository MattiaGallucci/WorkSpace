package poo23;

import java.util.Arrays;
import java.util.List;

public class Main 
{
    public static void main( String[] args ) {
        List<Punto> listaPunti1 = Arrays.asList(
                new Punto(1, 1),
                new Punto(3,1),
                new Punto(2,2)
        );
        List<Punto> listaPunti2 = Arrays.asList(
                new Punto(4, 1),
                new Punto(6,1),
                new Punto(5,3)
        );
        Triangolo triangolo1 = new Triangolo("Triangolo1", listaPunti1);
        Triangolo triangolo2 = new Triangolo("Triangolo2", listaPunti2);
        
        Disegno listaTriangoli = new Disegno();
        listaTriangoli.aggiungiFigura(triangolo1);
        listaTriangoli.aggiungiFigura(triangolo2);
        System.out.println(triangolo1);
        System.out.println(triangolo2);

        System.out.println("Baricentro Triangolo1: " + triangolo1.baricentro());
        System.out.println("Baricentro Triangolo2: " + triangolo2.baricentro());

        
    }
}
