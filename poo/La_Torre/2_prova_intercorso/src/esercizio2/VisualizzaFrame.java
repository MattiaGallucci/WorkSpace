package esercizio2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import allegati.Prodotto;
import esercizio1.Container;
import esercizio1.Criterio;
import esercizio1.FullContainerException;
import esercizio1.ItemNotFoundException;

public class VisualizzaFrame extends JFrame{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
	private JPanel controlPanel;
	private JButton eseguiButton;
	private JTextArea textArea;
	
	public VisualizzaFrame() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		add(createPanel(), BorderLayout.NORTH);
		add(createArea());
		JScrollPane scroll = new JScrollPane(textArea);
		add(scroll);
	}
	
	public JPanel createPanel() {
		controlPanel = new JPanel();
		controlPanel.add(createButton());
		
		return controlPanel;
	}
	
	public JButton createButton() {
		eseguiButton = new JButton("ESEGUI");
		
		class EseguiListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				File f = new File("container.dat");
				Container<Prodotto> container = null;
				
				if(f.exists()) {
					try {
						ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
						container = (Container<Prodotto>) in.readObject();
						in.close();
					} catch (IOException | ClassNotFoundException eexception) {
						textArea.append("Lettura fallita\n");
					}
				} else {
					Random random = new Random();
					container = new Container<>(20);
					for(int i=0; i<4; i++) {
						try {
							container.add(new Prodotto("Prodotto" + i, random.nextInt(1, 4)));
							textArea.append("Prodotto" + i + " aggiunto con successo" + "\n");
						} catch (FullContainerException e1) {
							textArea.append(e1.toString() + "\n");
						}
					}
					try {
						container.delete(new Prodotto("6", 6));
					} catch (ItemNotFoundException exc2) {
						textArea.append("Prodotto non trovato" + "\n");
					}

					// STAMPA NELLA CONSOLE
					// container.delete(new Prodotto("6", 6));
					
					//! NON SVOLTO
					class CriterioPeso implements Criterio<Prodotto>{
						public boolean useCriterio(Prodotto item) {
							if(item.getPeso() > 1)
								return true;
							else
								return false;
						}
					}
					// Criterio<Prodotto> criterioNome = p->p.getPeso()>1;
					Criterio<Prodotto> criterioPeso = new CriterioPeso();
					ArrayList<Prodotto> listaFiltrata = container.select(criterioPeso);
					for(Prodotto p : listaFiltrata)
						textArea.append(p.toString() + "\n");
					
					// container.getLista().stream().filter(p -> p.getPeso() >= 2).forEach(p -> textArea.append(p.toString() + "\n"));
				}
				
				try {
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
					out.writeObject(container);
					out.close();
				} catch(IOException exc3) {
					textArea.append("Salvataggio fallito\n");
				}
			}
		}
		ActionListener listener = new EseguiListener();
		eseguiButton.addActionListener(listener);
		
		return eseguiButton;
	}
	
	public JTextArea createArea() {
		textArea = new JTextArea(30, 30);
		textArea.setEditable(false);
		
		return textArea;
	}
}
