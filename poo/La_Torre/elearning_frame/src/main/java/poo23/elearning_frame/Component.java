package poo23.elearning_frame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Component extends JComponent {

	public void paintComponent(Graphics g) {
		// HEAD
		Graphics2D g2 = (Graphics2D) g;

		Ellipse2D.Double logo = new Ellipse2D.Double(10, 10, 40, 40);
		g2.draw(logo);

		Rectangle home = new Rectangle(70, 20, 40, 20);
		g2.draw(home);
		g2.drawString("Home", 75, 35);

		Rectangle lingua = new Rectangle(getWidth() - 130, 20, 60, 20);
		g2.draw(lingua);
		g2.drawString("Italiano (it)", getWidth() - 125, 35);

		Line2D.Double linea = new Line2D.Double(getWidth() - 60, 10, getWidth() - 60, 50);
		g2.draw(linea);

		Rectangle login = new Rectangle(getWidth() - 50, 20, 40, 20);
		g2.draw(login);
		g2.setColor(Color.BLUE);
		g2.drawString("Login", getWidth() - 45, 35);
		g2.setColor(Color.BLACK);

		// BODY
		Color backgroundColor = new Color((float) 0.945, (float) 0.964, (float) 0.992);
		g2.setColor(backgroundColor);
		Rectangle background = new Rectangle(0, 60, getWidth(), getHeight());
		g2.fill(background);
		g2.setColor(Color.BLACK);
		
		g2.drawString("News del Sito", 90, 120);
		
		Rectangle box = new Rectangle(90, 140, getWidth() - 180, getHeight());
		g2.draw(box);
		
		Ellipse2D.Double pfp = new Ellipse2D.Double(100, 150, 40, 40);
		g2.draw(pfp);
		
		g2.drawString("AVVISO: ripristino notifiche e.mail", 150, 160);
		g2.drawString("di " , 150, 180);
		g2.setColor(Color.BLUE);
		g2.drawString("Carlo Di Giampaolo " , 162, 180);
		g2.setColor(Color.BLACK);
		g2.drawString("- lunedì, 20 novembre 2023, 14:52" , 267, 180);
		
		g2.drawString("Buongiorno,", 150, 220);
		g2.drawString("sono stati risolti i problemi tecnici con il server di posta centralizzato che hanno impedito la ricezione delle notifiche via email per alcuni giorni.", 150, 260);
		g2.drawString("Il disservizio NON è dipeso dalla piattaforma ma a modifiche apportate alle configurazioni dei server di posta.", 150, 300);
		g2.drawString("Adesso il servizio funziona correttamente.", 150, 340);
		g2.drawString("Cordialmente.", 150, 380);

	}
}