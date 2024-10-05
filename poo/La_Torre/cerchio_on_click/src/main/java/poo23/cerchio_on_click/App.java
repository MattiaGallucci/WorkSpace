package poo23.cerchio_on_click;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class App {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;

	public static void main(String[] args) {
		final RaggioFrame frameRaggio = new RaggioFrame();
		JFrame frame = new JFrame();
		
		final CerchioComponent cerchio = new CerchioComponent((double) frameRaggio.getRaggio());
		
		class MouseClick implements MouseListener{
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				cerchio.moveTo(x, y, (double) frameRaggio.getRaggio());
			}
			
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		}
		
		MouseListener listener = new MouseClick();
		cerchio.addMouseListener(listener);
		
		frameRaggio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameRaggio.setVisible(true);
		
		frame.add(cerchio);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setVisible(true);
	}
}
