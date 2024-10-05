package poo23;

import javax.swing.JFrame;

public class CerchioFrame extends JFrame{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
	public CerchioFrame(RaggioFrame frame) {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		CerchioComponent component = new CerchioComponent(frame);
		add(component);
		repaint();
	}
}