package htoop22.BankGui;

import htoop22.Bank.Bank;
import htoop22.Bank.BankAccount;
import htoop22.Bank.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    public static void main( String[] args ) {
        Bank fiscianoBank= new Bank();
        Cliente c1 = new Cliente("Mario", "Rossi", 1001, 1234);
        fiscianoBank.addCostumer(c1);
        BankAccount b1 = new BankAccount(1000, c1);
        fiscianoBank.addConto(b1);

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JLabel depositLabel = new JLabel("Importo");
        final int FIELD_WIDTH = 5;
        final JTextField depositAmountField = new JTextField(FIELD_WIDTH);
        depositAmountField.setText("");

        JButton btnDeposit = new JButton("Deposita");

        final JLabel resultLabel = new JLabel("saldo: " + b1.getSaldo());

        panel.add(depositLabel);
        panel.add(depositAmountField);
        panel.add(btnDeposit);
        panel.add(resultLabel);

        frame.add(panel);

        class DepositMoneyListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(depositAmountField.getText());
                b1.deposit(amount);
                resultLabel.setText("saldo: " + b1.getSaldo());
                depositAmountField.setText("");
            }
        }

        ActionListener dml = new DepositMoneyListener();
        btnDeposit.addActionListener(dml);

        frame.setSize(500, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
