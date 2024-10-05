package poo23.cerchio_on_click;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class CerchioComponent extends JComponent{
	private double raggio;
	private Ellipse2D.Double cerchio;
	
	public CerchioComponent(double raggio) {
		cerchio = new Ellipse2D.Double(0, 0, 0, 0);
		this.raggio = raggio;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.draw(cerchio);
	}
	
	public void moveTo(int x, int y, double raggio) {
		cerchio = new Ellipse2D.Double(x-raggio, y-raggio, raggio*2, raggio*2);
		repaint();
	}
}
