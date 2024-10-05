package poo23.fill_quadrato;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class ColoredSquareComponent extends JComponent{
	private Color fillColor;

	public ColoredSquareComponent(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(fillColor);
		final int SQUARE_LENGHT = 100;
		
		Rectangle square = new Rectangle(
				(getWidth() - SQUARE_LENGHT)/2,
				(getHeight() - SQUARE_LENGHT)/2,
				SQUARE_LENGHT,
				SQUARE_LENGHT);
		
		g2.fill(square);
	}
}
