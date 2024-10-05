package poo23.investment_gui;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InvestmentFrame extends JFrame {
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private JLabel resultLabel;
	private BankAccount account;

	private static final double DEFAULT_RATE = 10.0;
	private static final double INITIAL_BALANCE = 1000.0;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 200;

	public InvestmentFrame() {
		account = new BankAccount(INITIAL_BALANCE);
		resultLabel = new JLabel("balance= " + account.getBalance());
		createRateField();
		createButton();
		createPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

	public void createRateField() {
		rateLabel = new JLabel("Tassa d'interesse: ");
		final int FIELD_WIDTH = 10;
		rateField = new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);
	}

	public void createButton() {
		button = new JButton("Aggiungi interesse");

		class AddInterestListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				double rate = Double.parseDouble(rateField.getText());
				double interest = account.getBalance() * rate / 100;

				account.deposit(interest);
				resultLabel.setText("balance= " + account.getBalance());
			}
		}
		ActionListener listener = new AddInterestListener();
		button.addActionListener(listener);
	}
	
	public void createPanel() {
		JPanel panel = new JPanel();
		panel.add(rateLabel);
		panel.add(rateField);
		panel.add(button);
		panel.add(resultLabel);
		add(panel);
	}
}