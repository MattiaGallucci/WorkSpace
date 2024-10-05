package poo23.cerchio_on_click;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RaggioFrame extends JFrame {
	private JLabel raggioLabel;
	private JTextField raggioField;

	private static final int FRAME_WIDTH = 200;
	private static final int FRAME_HEIGHT = 100;

	public RaggioFrame() {
		raggioLabel = new JLabel("Raggio=");
		raggioField = new JTextField(5);
		raggioField.setText("" + 50);
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public void createPanel() {
		JPanel panel = new JPanel();
		panel.add(raggioLabel);
		panel.add(raggioField);
		add(panel);
	}
	
	public float getRaggio() {
		return Float.parseFloat(raggioField.getText());
	}
}
