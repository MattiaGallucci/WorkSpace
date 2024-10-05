package poo23;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

import javax.swing.JComponent;

public class CerchioComponent extends JComponent{
	private Ellipse2D.Double cerchio;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		Random x = new Random();
		int raggio = x.nextInt(250);
		
		cerchio = new Ellipse2D.Double(x.nextInt(getWidth()), x.nextInt(getHeight()), raggio, raggio);
		
		g2.draw(cerchio);
		g2.fill(cerchio);
	}
}
