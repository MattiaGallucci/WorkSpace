package poo23;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RaggioFrame extends JFrame{
	private static final int FRAME_WIDTH = 200;
	private static final int FRAME_HEIGHT = 100;
	
	private JPanel panel;
		private JLabel raggioLabel;
		private JTextField inputField;
	
	public RaggioFrame() {
		panel = new JPanel();
		raggioLabel = new JLabel("Raggio =");
		inputField = new JTextField(10);
		inputField.setText("0");
		
		panel.add(raggioLabel);
		panel.add(inputField);
		
		add(panel);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public int getRaggio() {
		return Integer.parseInt(inputField.getText());
	}
}
