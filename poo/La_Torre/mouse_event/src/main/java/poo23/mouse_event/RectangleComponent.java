package poo23.mouse_event;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent{
	private Rectangle box;
	private static final int BOX_X = 100;
	private static final int BOX_Y = 100;
	private static final int BOX_WIDTH = 20;
	private static final int BOX_HEIGHT = 30;
	
	public RectangleComponent() {
		box = new Rectangle(BOX_X, BOX_Y, BOX_WIDTH, BOX_HEIGHT);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.draw(box);
	}
	
	/* 	Moves the rectangle to the given location.
		@param x the x position of the new location
		@param y the y position of the new location */
	public void moveTo(int x, int y) {
		box.setLocation(x, y);
		repaint();
	}
}
