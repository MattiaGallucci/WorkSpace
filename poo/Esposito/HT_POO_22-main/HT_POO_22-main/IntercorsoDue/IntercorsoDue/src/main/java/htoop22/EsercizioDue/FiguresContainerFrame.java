package htoop22.EsercizioDue;

import htoop22.EsercizioUno.NotPlottableException;
import htoop22.EsercizioUno.OutOfMarginException;

import javax.swing.*;
import java.awt.*;

public class FiguresContainerFrame extends JFrame {

    public FiguresContainerFrame() {
        setTitle("Draw Viewer");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    public void addFigureToFrame(Object p) throws OutOfMarginException {
        if (!(p instanceof Plottable)) {
            throw new NotPlottableException("La figura piana non è plottabile");
        } else {
            Graphics2D g2 = (Graphics2D) getGraphics();
            ((Plottable) p).plot(g2, getWidth(), getHeight());
        }
    }

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
}

