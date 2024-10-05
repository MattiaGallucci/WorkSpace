package htoop22.EsercizioDue;

import htoop22.EsercizioUno.NotPlottableException;
import htoop22.EsercizioUno.OutOfMarginException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FiguresViewer {

    public static void main(String[] args) {
        ReportFrame report = new ReportFrame();
        report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Object> figures = generateFigures();
        FiguresContainerFrame frame = new FiguresContainerFrame();
        frame.setVisible(true);
        int cont = 0;
        int max_area = 0;
        Polygon p_max = null;
        for (Object o:figures) {
            try {
                frame.addFigureToFrame(o);
                Plottable p = (Plottable) o;
                if (p.getArea() > max_area) {
                    max_area = p.getArea();
                    p_max = p.getPolygonToPlot();
                }
            } catch (OutOfMarginException e2) {
                cont++;
            }
        }
        report.addTextToTextarea("Non è stato possibile disegnare " + cont + " figure.");
        report.addTextToTextarea("La figura di area massima è " + max_area + ", i dati sono " + p_max);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        report.setVisible(true);


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

        /* Lambda function */
        Plottable rombo = () ->new Polygon(new int[]{825, 850, 825, 800}, new int[]{800, 850, 900, 850}, 4);

        ArrayList<Object> list = new ArrayList<>();
        list.add(quadrato);
        list.add(triangolo);
        list.add(rombo);
        list.add(new Rectangle(10, 10, 10, 10));
        return list;
    }
}
