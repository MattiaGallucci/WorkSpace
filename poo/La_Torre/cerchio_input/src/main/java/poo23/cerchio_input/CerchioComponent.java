package poo23.cerchio_input;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class CerchioComponent extends JComponent{
	private double raggio;
	private Color fillColor;
	
	public CerchioComponent(double raggio) {
		this.raggio = raggio;
	}
	public CerchioComponent(Color aColor) {
		fillColor = aColor;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(fillColor);
		
		Ellipse2D.Double cerchio = new Ellipse2D.Double(0, 0, getWidth(), getHeight());
		g2.draw(cerchio);
		g2.fill(cerchio);
	}
}
