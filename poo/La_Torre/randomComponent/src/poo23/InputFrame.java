package poo23;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputFrame extends JFrame{
	private static final int FRAME_WIDTH = 350;
	private static final int FRAME_HEIGHT = 100;
	
	private JPanel inputPanel;
	private JPanel buttonPanel;
	private JLabel textLabel;
	private JTextField textField;
	private JButton drawButton;
	private VisualizzaFrame frame;
	
	public InputFrame() {		
		inputPanel = new JPanel();
		textLabel = new JLabel("Numero di rettangoli");
		textField = new JTextField(10);
		textField.setText("0");
		inputPanel.add(textLabel);
		inputPanel.add(textField);
		
		buttonPanel = new JPanel();
		drawButton = new JButton("Disegna");
		buttonPanel.add(drawButton);
		
		class DrawListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				frame = new VisualizzaFrame();
				RectangleComponent component = new RectangleComponent(Integer.parseInt(textField.getText()));
				frame.add(component);
				
				frame.setVisible(true);
				frame.repaint();
			}
		}
		
		ActionListener listener = new DrawListener();
		drawButton.addActionListener(listener);
		
		add(inputPanel, BorderLayout.WEST);
		add(buttonPanel, BorderLayout.EAST);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

}
