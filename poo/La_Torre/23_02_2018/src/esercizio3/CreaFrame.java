package esercizio3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import esercizio1.Arredo;
import esercizio1.Coppia;
import esercizio1.DivanoLetto;
import esercizio1.Letto;
import esercizio2.Algoritmo;
import esercizio2.Criterio;

public class CreaFrame extends JFrame{
	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 500;
	
	ArrayList<String> stringList;
	ArrayList<Letto> lettoList;
	ArrayList<DivanoLetto> divanoLettoList;
	ArrayList<Arredo> arrediList;
	
	private JPanel controlPanel;
		private JPanel stringPanel;
			private JButton stringButton;
		private JPanel classPanel;
			private JButton classButton;
	private JTextArea textArea;
		private JScrollPane scrollPane;
	
	public CreaFrame(ArrayList<String> sList, ArrayList<Letto> lList, ArrayList<DivanoLetto> dlList) {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		stringList = sList;
		arrediList = new ArrayList<Arredo>(lList);
		arrediList.addAll(dlList);
		
		add(createControlPanel(), BorderLayout.NORTH);
	}
	
	public JPanel createControlPanel() {
		controlPanel = new JPanel();
		controlPanel.add(createStringPanel());
		controlPanel.add(createClassPanel());
		
		add(createTextArea());
		scrollPane = new JScrollPane(textArea);
		add(scrollPane);
		
		return controlPanel;
	}
	
	public JPanel createStringPanel() {
		stringPanel = new JPanel();
		stringPanel.add(createStringButton());
		
		return stringPanel;
	}
	
	public JButton createStringButton() {
		stringButton = new JButton("String");
		
		class StringListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				ordinaStringhe();
			}
		}
		
		ActionListener listener1 = new StringListener();
		stringButton.addActionListener(listener1);
		
		return stringButton;
	}
	
	public JPanel createClassPanel() {
		classPanel = new JPanel();
		classPanel.add(createClassButton());
		
		return classPanel;
	}
	
	public JButton createClassButton() {
		classButton = new JButton("Class");
		
		class ClassListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				ordinaLetti();
			}
		}
		
		ActionListener listener2 = new ClassListener();
		classButton.addActionListener(listener2);
		
		return classButton;
	}
	
	public JTextArea createTextArea() {
		textArea = new JTextArea(20, 20);
		textArea.setEditable(false);
		
		return textArea;
	}
	
	public void ordinaStringhe() {
		Criterio<String> criterioString = new Criterio<String>() {
			public int useCriterio(String item1, String item2) {
				return item1.compareTo(item2);
			}
		};
		
		Algoritmo algoritmo1 = new Algoritmo();
		textArea.append(algoritmo1.ordina(stringList, criterioString).toString() + "\n");
	}
	
	public void ordinaLetti() {
		Criterio<Arredo> criterioArredo = new Criterio<>() {
			public int useCriterio(Arredo coppia1, Arredo coppia2) {
				int confrontoPrimiNumeri = coppia1.getMisura().getOggetto1().compareTo(coppia2.getMisura().getOggetto1());

                if (confrontoPrimiNumeri != 0) {
                    return confrontoPrimiNumeri;
                } else {
                    return coppia1.getMisura().getOggetto2().compareTo(coppia2.getMisura().getOggetto2());
                }
			}
		};
		
		Algoritmo algoritmo2 = new Algoritmo();
		textArea.append(algoritmo2.ordina(arrediList, criterioArredo).toString() + "\n");
	}
	
}
