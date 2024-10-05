package poo23.rettangoli_casuali;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumeriRettangoliFrame extends JFrame{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 100;

	private JLabel rettangoliLabel;
	private JTextField numeroField;
	private JButton disegnaButton;
	
	private int numeroRettangoli;
	
	public NumeriRettangoliFrame() {
		rettangoliLabel = new JLabel("Numero di rettangoli:");
		numeroField = new JTextField(5);
		numeroField.setText("" + 5);
		numeroRettangoli = Integer.parseInt(numeroField.getText());
		createButton();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createPanel() {
		JPanel panel = new JPanel();
		panel.add(rettangoliLabel);
		panel.add(numeroField);
		panel.add(disegnaButton);
		
		add(panel);
	}
	
	public void createButton() {
		disegnaButton = new JButton("Disegna");
		
		class Disegna implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				numeroRettangoli = Integer.parseInt(numeroField.getText());
			}
		}
		ActionListener listener = new Disegna();
		disegnaButton.addActionListener(listener);
	}
	
	public double getNumero() {
		return numeroRettangoli;
	}
}
