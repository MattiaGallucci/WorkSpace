package htoop22.ResizableSquare;

import javax.swing.*;
import java.awt.*;

public class ResizableSquareComponent extends JComponent {

    private double squareSize;

    public ResizableSquareComponent(double size) {
        this.squareSize = size;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle sqaure = new Rectangle((int) ((getWidth() - this.squareSize) / 2), (int) ((getHeight() - this.squareSize) / 2 ), (int) squareSize, (int) squareSize);
        g2.draw(sqaure);
        g2.setColor(Color.CYAN);
        g2.fill(sqaure);
    }
}
