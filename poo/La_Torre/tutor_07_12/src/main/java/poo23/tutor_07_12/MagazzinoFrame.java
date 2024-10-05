package poo23.tutor_07_12;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class MagazzinoFrame extends JFrame{
	private Magazzino magazzino;
	
	private JRadioButton inserisci;
	private JRadioButton visualizza;
	private JTextArea area;
	
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 150;
	
	public MagazzinoFrame(Magazzino m) {
		magazzino = m;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		add(createCenter(),BorderLayout.CENTER);
		add(createNorth(),BorderLayout.NORTH);
	}
	
	public JPanel createCenter() {
		JPanel panel = new JPanel();
		
		area = new JTextArea(10, 20);
		panel.add(area);
		
		return panel;
	}
	
	public JPanel createNorth() {
		JPanel panel = new JPanel();
		inserisci = new JRadioButton();
		visualizza = new JRadioButton();
		
		ButtonGroup group = new ButtonGroup();
		group.add(inserisci);
		group.add(visualizza);
		
		class VisualizzaProdottiListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				area.setText("");
				for(Prodotto p : magazzino.getProdotti())
					area.append(p + "\n");
			}
		}
		
		class InserisciProdottoListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JFrame nuovo = new MagazzinoInserimentoFrame(magazzino);
				nuovo.setVisible(true);
			}
		}
		
		inserisci.addActionListener(new InserisciProdottoListener());
		visualizza.addActionListener(new VisualizzaProdottiListener());
		
		panel.add(inserisci);
		panel.add(visualizza);
		
		return panel;
	}
}
