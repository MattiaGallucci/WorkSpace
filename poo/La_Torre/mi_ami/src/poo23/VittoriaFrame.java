package poo23;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VittoriaFrame extends JFrame{
	private final int FRAME_WIDTH = 200;
	private final int FRAME_HEIGHT = 200;
	
	public VittoriaFrame() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		JLabel label = new JLabel("HAI VINTO");
		JPanel panel = new JPanel();
		panel.add(label, BorderLayout.CENTER);
		add(panel, BorderLayout.CENTER);
	}

}
