package poo23.tutor_07_12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MagazzinoInserimentoFrame extends JFrame{
	private JTextField nome;
	private JTextField quantita;
	private JTextField prezzo;
	private Magazzino magazzino;
	
	public MagazzinoInserimentoFrame(Magazzino m) {
		magazzino = m;
		
		add(createCenter(), BorderLayout.CENTER);
	}
	
	public JPanel createCenter() {
		JPanel panel = new JPanel();
		
		JLabel nomeLabel = new JLabel("Nome: ");
		nome = new JTextField();
		
		JLabel quantitaLabel = new JLabel("Quantità: ");
		quantita = new JTextField();
		
		JLabel prezzoLabel = new JLabel("Prezzo: ");
		prezzo = new JTextField();
		
		JButton button = new JButton("Inserisci");
		
		panel.add(nomeLabel);
		panel.add(nome);
		panel.add(quantitaLabel);
		panel.add(quantita);
		panel.add(prezzoLabel);
		panel.add(prezzo);
		
		class InserisciActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				Prodotto p = new Prodotto(nome.getText(), Integer.parseInt(quantita.getText()), Integer.parseInt(prezzo.getText()));
				
				try {
					magazzino.aggiungiProdotto(p);
				} catch (ItemAlreadyPresentException e1) {
					System.out.println(e1.getMessage());
				}
			}
		}
		
		return panel;
	}

}
