package poo23;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CollezioneFrame extends JFrame{
	final int FRAME_WIDTH = 500;
	final int FRAME_HEIGHT = 500;
	
	public CollezioneFrame() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(createCerchioButton());
		buttonPanel.add(createQuadratoButton());
		add(buttonPanel, BorderLayout.NORTH);
	}
	
	public JButton createCerchioButton() {
		JButton cerchioButton = new JButton("Cerchio");
		
		class DisegnaCerchioListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				CerchioComponent cerchio = new CerchioComponent();
				add(cerchio);
				revalidate();
				repaint();
			}
		}
		ActionListener listener = new DisegnaCerchioListener();
		cerchioButton.addActionListener(listener);
		
		return cerchioButton;
	}
	
	public JButton createQuadratoButton() {
		JButton quadratoButton = new JButton("2 Quadrati");
		
		class DisegnaQuadratoListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				QuadratoComponent quadrato = new QuadratoComponent();
				add(quadrato);
				revalidate();
				repaint();
			}
		}
		ActionListener listener = new DisegnaQuadratoListener();
		quadratoButton.addActionListener(listener);
		
		return quadratoButton;
	}
}
