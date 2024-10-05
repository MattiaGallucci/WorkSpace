package poo23.BankAccount_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class BankFrame extends JFrame{
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 400;
	
	private JTextArea textArea;
	
	private JPanel controlPanel;
		private JPanel importoPanel;
			private JLabel importoLabel;
			private JTextField importoField;
		private JPanel sceltaPanel;
			private JRadioButton depositoButton;
			private JRadioButton prelevaButton;
		private JPanel eseguiPanel;
			private JButton eseguiButton;
	
	private BankAccount account;
	
	public BankFrame() {
		account = new BankAccount(1000.0);
		
		createTextArea();
		
		controlPanel = new JPanel();
		importoPanel = createImportoPanel();
		sceltaPanel = createSceltaPanel();
		eseguiPanel = createEseguiPanel();
		controlPanel.add(importoPanel);
		controlPanel.add(sceltaPanel);
		controlPanel.add(eseguiPanel);
		
		// add(textArea, BorderLayout.CENTER); 	//	SE LO AGGIUNGI NON VEDI SCROLLPANE
		add(controlPanel, BorderLayout.SOUTH);
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public void createTextArea() {
		textArea = new JTextArea(10, 30);
		textArea.setEditable(false);
		textArea.append("Current balance: " + account.getBalance() + "\n");
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane);
	}
	
	public JPanel createImportoPanel(){
		importoLabel = new JLabel("Importo: ");
		importoField = new JTextField(10);
		importoField.setText("");
		
		JPanel panel = new JPanel();
		panel.add(importoLabel);
		panel.add(importoField);
		
		return panel;
	}
	
	public int getImporto() {
		return Integer.parseInt(importoField.getText());
	}
	
	public JPanel createSceltaPanel(){
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Scelta"));
		
		depositoButton = new JRadioButton("Deposita");
		prelevaButton = new JRadioButton("Preleva");
		
		ButtonGroup group = new ButtonGroup();
		group.add(depositoButton);
		group.add(prelevaButton);
		
		panel.add(depositoButton);
		panel.add(prelevaButton);
		
		return panel;
	}
	
	public JPanel createEseguiPanel() {
		JPanel panel = new JPanel();
		eseguiButton = new JButton("Esegui");
		panel.add(eseguiButton);
		
		class EseguiAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(depositoButton.isSelected()) {
					account.deposit(getImporto());
					textArea.append("Current balance : " + account.getBalance() + "\n");
				}
				else if(prelevaButton.isSelected()){
					if(getImporto() > account.getBalance())
						textArea.append("Impossibile prelevare " + getImporto() + "\n");
					account.withdraw(getImporto());
					textArea.append("Current balance: " + account.getBalance() + "\n");
				}
				else
					textArea.append("Current balance: " + account.getBalance() + "\n");
			}
		}
		ActionListener listener = new EseguiAction();
		eseguiButton.addActionListener(listener);
		
		return panel;
	}
	
}
