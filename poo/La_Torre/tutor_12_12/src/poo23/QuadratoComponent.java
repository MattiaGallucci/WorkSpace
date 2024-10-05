package poo23;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;

public class QuadratoComponent extends JComponent{
	private Rectangle quadrato;
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		Random x = new Random();
		
		int lato = x.nextInt(250);
		quadrato = new Rectangle(x.nextInt(getWidth()), x.nextInt(getHeight()), lato, lato);
		g2.setColor(Color.BLUE);
		g2.draw(quadrato);
		g2.fill(quadrato);
		
		int lato1 = x.nextInt(250);
		quadrato = new Rectangle(x.nextInt(getWidth()), x.nextInt(getHeight()), lato1, lato1);
		g2.setColor(Color.PINK);
		g2.draw(quadrato);
		g2.fill(quadrato);
	}
}
