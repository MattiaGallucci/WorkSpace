package poo23;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class CerchioComponent extends JComponent {
	private Ellipse2D.Double cerchio;
	private int raggio;

	public CerchioComponent(RaggioFrame frame) {
		cerchio = new Ellipse2D.Double(0, 0, 0, 0);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		class DrawListener implements MouseListener{
			public void mouseClicked(MouseEvent e) {
				cerchio.moveTo(e.getX(), e.getY());
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		}
		
		MouseListener listener = new DrawListener();
		addMouseListener(listener);
		
		g2.draw(cerchio);
	}

	public void moveTo(int x, int y) {

	}
}