package poo23;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClienteFrame extends JFrame{
	private final int FRAME_WIDTH = 300;
	private final int FRAME_HEIGHT = 400;
	private List<Cliente> clienti;
	
	private JMenuBar menuBar;
	private JTextArea textArea;
	
	public ClienteFrame(List<Cliente> lista) {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		clienti = lista;
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		
		textArea = new JTextArea(getWidth(), getHeight());
		textArea.setEditable(false);
		add(textArea, BorderLayout.NORTH);
	}
	
	public JMenu createFileMenu() {
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(createApriItem());
		fileMenu.add(createAcquistaItem());
		//fileMenu.add(createExitItem());
		return fileMenu;
	}
	
	public JMenuItem createApriItem() {
		JMenuItem item = new JMenuItem("Apri");
		
		class ApriListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				for(Cliente cliente : clienti)
					textArea.append(cliente.toString() + "\n");
			}
		}
		
		ActionListener listener = new ApriListener();
		item.addActionListener(listener);
		
		return item;
	}
	
	public JMenuItem createAcquistaItem() {
		JMenuItem item = new JMenuItem("Acquista");
		
		class AcquistaListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				AcquistaFrame frame = new AcquistaFrame(clienti);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		
		ActionListener listener = new AcquistaListener();
		item.addActionListener(listener);
		
		return item;
	}
}
