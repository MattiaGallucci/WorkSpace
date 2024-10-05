package htoop22.EsercizioTre;

import htoop22.EsercizioDue.FiguresContainerFrame;
import htoop22.EsercizioDue.Plottable;
import htoop22.EsercizioUno.OutOfMarginException;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class TestEsercizioDue {

    public static void main(String[] args) {

        File f = new File("figure.dat");
        ArrayList<Object> figures_list = null;
        if (f.exists()) {
            try {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
                figures_list = (ArrayList<Object>) in.readObject();
                in.close();
            } catch (ClassNotFoundException err) {
                System.out.println("Impossibile trovare la classe oppure deserializzazione fallita.");
            } catch (IOException e) {
                System.out.println("Errore nell'apertura del file.");
            }
        } else {
          figures_list = generateFigures();
        }

        FiguresContainerFrame frame = new FiguresContainerFrame();
        frame.setVisible(true);

        int i = 0;
        for (Object p : figures_list) {
            System.out.println("Provo a disegnare la figura con indice " + i);
            try {
                frame.addFigureToFrame(p);
                System.out.println("Figura disegnata correttamente");
            } catch (OutOfMarginException e) {
                System.out.println("Errore: figura non plottabile a causa dei margini");
            }
            i++;
        }

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(figures_list);
            out.close();
        } catch (IOException e) {
            System.err.println("Impossibile salvare il file oppure serializzazione fallita.");
        }


    }

    private static ArrayList<Object> generateFigures() {

        /* Classe anonima */
        Plottable quadrato = new Plottable() {
            @Override
            public Polygon getPolygonToPlot() {
                return new Polygon(new int[]{300, 350, 350, 300}, new int[]{300, 300, 350,350}, 4);
            }
        };

        /* Classe interna */
        class Triangolo implements Plottable {
            private final Polygon poly;

            public Triangolo() {
                this.poly = new Polygon(new int[]{100, 150, 125}, new int[]{100, 100, 200}, 3);
            }

            @Override
            public Polygon getPolygonToPlot() {
                return this.poly;
            }
        }
        Plottable triangolo = new Triangolo();

        /* Funzione lambda */
        Plottable rombo = () ->new Polygon(new int[]{825, 850, 825, 800}, new int[]{800, 850, 900, 850}, 4);

        ArrayList<Object> list = new ArrayList<>();
        list.add(quadrato);
        list.add(triangolo);
        list.add(rombo);
        return list;
    }


}
