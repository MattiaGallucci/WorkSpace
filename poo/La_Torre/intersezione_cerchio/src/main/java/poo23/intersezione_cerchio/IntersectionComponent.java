package poo23.intersezione_cerchio;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

/* 	A component that computes and draws the intersection points
	of a circle and a line.*/

public class IntersectionComponent extends JComponent {
	private double x;

	/* 	Constructs the component from a given x value for the line
		@param anX the x value for the line (between 0 and 200)*/
	public IntersectionComponent(double x) {
		this.x = x;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		final double RADIUS = 100;

		Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, 2 * RADIUS, 2 * RADIUS);
		g2.draw(circle);
		
		/*	Draw the vertical line*/
		Line2D.Double line = new Line2D.Double(x, 0, x, 2 * RADIUS);
		g2.draw(line);
		
		/* 	Compute the intersection points */
		double a = RADIUS;
		double b = RADIUS;
		
		double root = Math.sqrt(RADIUS * RADIUS - (x - a) * (x - a));
		double y1 = b + root;
		double y2 = b - root;
		
		/*	Draw the intersection points*/
		LabeledPoint p1 = new LabeledPoint(x, y1);
		LabeledPoint p2 = new LabeledPoint(x, y2);
		
		p1.disegna(g2);
		p2.disegna(g2);
	}
}
