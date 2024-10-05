package esercizio2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class RettangoloComponent extends JComponent{
	private Rectangle rettangolo;
	private int x, y, w, h;
	
	public RettangoloComponent(int x, int y, int w, int h) {
		rettangolo = new Rectangle(x, y, w, h);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.draw(rettangolo);
	}
	
	public void moveTo(int x, int y, int w, int h) {
		rettangolo.setLocation(x, y);
		rettangolo.setSize(w, h);
		repaint();
	}

}
