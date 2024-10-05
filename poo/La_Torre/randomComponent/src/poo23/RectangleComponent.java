package poo23;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent{
	private int n;
	
	public RectangleComponent(int n) {
		this.n = n;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		for(int i=0; i<n; i++) {
			Random random = new Random();

	        int numeroCasuale1 = random.nextInt(440);
	        int numeroCasuale2 = random.nextInt(470);
			Rectangle box = new Rectangle(numeroCasuale1, numeroCasuale2, 30, 60);
			g2.draw(box);
		}
	}
}
