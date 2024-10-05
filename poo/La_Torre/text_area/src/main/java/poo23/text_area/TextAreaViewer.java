package poo23.text_area;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaViewer {
	private static final double DEFAULT_RATE = 10;
	private static final double INITIAL_BALANCE = 1000;
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 200;

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final BankAccount account = new BankAccount(INITIAL_BALANCE);

		final int AREA_ROWS = 10;
		final int AREA_COLUMNS = 30;

		final JTextArea textArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		textArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(textArea);

		JLabel rateLabel = new JLabel("Tassa d'interesse: ");

		final int FIELD_WIDTH = 10;
		final JTextField rateField = new JTextField(FIELD_WIDTH);
		rateField.setText("" + DEFAULT_RATE);

		JButton calculateButton = new JButton("Aggiungi interesse");

		JPanel northPanel = new JPanel();
		northPanel.add(rateLabel);
		northPanel.add(rateField);
		northPanel.add(calculateButton);

		frame.add(northPanel, BorderLayout.NORTH);
		frame.add(scrollPane);

		class CalculateListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				double rate = Double.parseDouble(rateField.getText());
				double interest = account.getBalance() * rate / 100;
				account.deposit(interest);
				textArea.append(account.getBalance() + "\n");
			}

		}
		ActionListener listener = new CalculateListener();
		calculateButton.addActionListener(listener);

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
