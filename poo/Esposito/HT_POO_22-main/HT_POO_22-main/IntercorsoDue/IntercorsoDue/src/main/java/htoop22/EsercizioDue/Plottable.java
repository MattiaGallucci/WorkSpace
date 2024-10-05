package htoop22.EsercizioDue;

import htoop22.EsercizioUno.OutOfMarginException;

import java.awt.*;
import java.io.Serializable;

public interface Plottable extends Serializable {

    long serialVersionUID = 1L;

    Polygon getPolygonToPlot();

    /**
     * Metodo per ottenere l'area del poligono
     * @return l'area dell'oggetto
     */
    default int getArea() {
        Shape shape = getPolygonToPlot();
        return shape.getBounds().height * shape.getBounds().width;
    }

    /**
     * Metodo per disegnare un Plottable su un frame
     * @param g l'oggetto grafico su cui effettuare il disegno
     * @param amp l'ampiezza del frame
     * @param alt l'altezza del frame
     * @throws OutOfMarginException nel caso in cui il Plottable non rientra nel frame
     */
    default void plot(Graphics2D g, int amp, int alt) throws OutOfMarginException {
        Shape shape = getPolygonToPlot();

        int tot_width = shape.getBounds().x + shape.getBounds().width;
        int tot_height = shape.getBounds().y + shape.getBounds().height;

        if (tot_height > alt || tot_width > amp) {
            throw new OutOfMarginException("L'ampiezza o l'altezza escono dai margini.");
        }
        g.draw(getPolygonToPlot());

    }

}
