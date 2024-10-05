package esercizio3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CalcolatriceFrame extends JFrame{
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 150;
	
	JPanel operandoPanel;
		JTextField field1;
		JTextField field2;
	JPanel buttonPanel;
		JRadioButton addButton;
		JRadioButton timesButton;
	JPanel risultatoPanel;
		JLabel risultatoLabel;
	
	public CalcolatriceFrame() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		createOperandoPanel();
		createButtonPanel();
		createRisultatoPanel();
	}
	
	public void createOperandoPanel() {
		operandoPanel = new JPanel();
		operandoPanel.setLayout(new BorderLayout());
		operandoPanel.add(createOperando1Panel(), BorderLayout.NORTH);
		operandoPanel.add(createOperando2Panel(), BorderLayout.CENTER);
		add(operandoPanel, BorderLayout.WEST);
	}
	
	public JPanel createOperando1Panel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Operando 1");
		field1 = new JTextField(10);
		
		panel.add(label);
		panel.add(field1);
		
		return panel;
	}
	
	public JPanel createOperando2Panel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Operando 2");
		field2 = new JTextField(10);
		
		panel.add(label);
		panel.add(field2);
		
		return panel;
	}
	
	public void createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,1));
		
		addButton = new JRadioButton("add");
		
		timesButton = new JRadioButton("mult");
		ButtonGroup group = new ButtonGroup();
		group.add(addButton);
		group.add(timesButton);
		
		buttonPanel.add(addButton);
		buttonPanel.add(timesButton);
		add(buttonPanel, BorderLayout.EAST);
	}
	
	public void createRisultatoPanel() {
		risultatoPanel = new JPanel();
		JButton ugualeButton = new JButton("=");
		
		class EseguiListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String operando1 = field1.getText();
				String opernado1Modificato = operando1.replace(",", ".");
				double x = Double.parseDouble(opernado1Modificato);
				
				String operando2 = field2.getText();
				String opernado2Modificato = operando2.replace(",", ".");
				double y = Double.parseDouble(opernado2Modificato);
				
				double result;
				if(addButton.isSelected()) {
					result = x+y;
					risultatoLabel.setText("" + result);
				}
				
				if(timesButton.isSelected()) {
					result = x*y; 
					risultatoLabel.setText("" + result);
				}
			}
		}
		
		ActionListener listener = new EseguiListener();
		ugualeButton.addActionListener(listener);
		
		risultatoLabel = new JLabel("0");
		
		risultatoPanel.add(ugualeButton);
		risultatoPanel.add(risultatoLabel);
		
		add(risultatoPanel, BorderLayout.SOUTH);
	}
}
