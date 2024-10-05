package poo23.applicazione_grafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent{
	public void paintComponent(Graphics g) {
		// Recover Graphics2D
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		
		// Construct a rectangle and draw it
		Rectangle box = new Rectangle(5, 19, 20, 30);
		g2.draw(box);
		
		// Move rectangle 15 units to the right and 25 units down and draw it
		box.translate(15, 25);
		g2.draw(box);
		
		Line2D.Double segment = new Line2D.Double(60, 70, 80, 70);
		g2.draw(segment);
		
		g2.drawString("TI AMO CHICCA <3", 150, 200);
	}
}
