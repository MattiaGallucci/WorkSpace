package poo23.intersezione_cerchio;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/* 	A point with a label showing the point's coordinates. */

public class LabeledPoint {
	private static final double SMALL_CIRCLE_RADIUS = 2;
	private double x;
	private double y;

	/*	Construct a labeled point.
		@param anX the x coordinate
		@param aY the y coordinate*/
	public LabeledPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/* 	Draws the point as a small circle with a coordinate label.
	  	@param g2 the graphics context*/
	public void disegna(Graphics2D g2) {
		Ellipse2D.Double circle = new Ellipse2D.Double(
				x - SMALL_CIRCLE_RADIUS,
				y - SMALL_CIRCLE_RADIUS,
				2 * SMALL_CIRCLE_RADIUS,
				2 * SMALL_CIRCLE_RADIUS);
		g2.draw(circle);
		
		String label = "(" + x + "," + y + ")";
		g2.drawString(label, (float) x, (float) y);
	}
}
