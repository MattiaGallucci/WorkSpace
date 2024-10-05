package poo23;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AcquistaFrame extends JFrame{
	private final int FRAME_WIDTH = 300;
	private final int FRAME_HEIGHT = 150;
	
	private JPanel nomePanel;
	private JPanel importoPanel;
	JLabel nomeLabel;
	JTextField nomeField;
	JLabel importoLabel;
	JTextField importoField;
	JButton button;
	private List<Cliente> clienti;
	
	public AcquistaFrame(List<Cliente> lista) {
		clienti = lista;
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		nomePanel = new JPanel();
		nomeLabel = new JLabel("Nome:");
		nomeField = new JTextField(10);
		nomePanel.add(nomeLabel);
		nomePanel.add(nomeField);
		add(nomePanel, BorderLayout.NORTH);
		
		importoPanel = new JPanel();
		importoLabel = new JLabel("Importo:");
		importoField = new JTextField(10);
		importoPanel.add(importoLabel);
		importoPanel.add(importoField);
		add(importoPanel, BorderLayout.CENTER);
		
		button = new JButton("OK");
		class OKListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				for(Cliente cliente : clienti) {
					//if(cliente.getNome() == getNome()) {
						System.out.println(cliente.acquista(getImporto()));
					//}
				}
			}
		}
		
		ActionListener listener = new OKListener();
		button.addActionListener(listener);
		
		add(button, BorderLayout.SOUTH);
	}
	
	public String getNome() {
		return nomeField.getText();
	}
	
	public double getImporto() {
		return Double.parseDouble(importoField.getText());
	}

}
