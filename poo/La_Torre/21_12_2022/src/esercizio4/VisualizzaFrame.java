package esercizio4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import esercizio2.CentroUrbanoMappa;
import esercizio3.Centri;
import esercizio3.Criterio;

public class VisualizzaFrame extends JFrame {
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;

	private Centri<CentroUrbanoMappa> centri;

	private JPanel controlPanel;
		private JPanel rangePanel;
		private JPanel NazionePanel;
		private JPanel VisualizzaPanel;
	private ButtonGroup group;
	private JRadioButton visualizzaButton;
	private JRadioButton rangeButton;
	private JRadioButton nazioneButton;
	private JTextArea textArea;
	private JTextField range1Field;
	private JTextField range2Field;
	private JTextField nazioneField;
	private JCheckBox mappaCheckBox;

	public VisualizzaFrame(Centri<CentroUrbanoMappa> c) {
		centri = c;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(4, 1));
		controlPanel.add(createRangePanel());
		controlPanel.add(createVisualizzaButton());
		controlPanel.add(createNazionePanel());
		controlPanel.add(createMappaCasella());
		
		group = new ButtonGroup();
		group.add(visualizzaButton);
		group.add(rangeButton);
		group.add(nazioneButton);
		
		add(controlPanel, BorderLayout.NORTH);
		textArea = new JTextArea(20, 30);
		textArea.setEditable(false);
		JScrollPane scroll = new JScrollPane(textArea);
		add(scroll);

	}
	
	public JCheckBox createMappaCasella() {
		mappaCheckBox = new JCheckBox("Visualizza mappa");
		
		class MappaListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(mappaCheckBox.isSelected()) {
					JFrame frameMappa = new MappaFrame(centri);
					frameMappa.setVisible(true);
				}
			}
		}
		
		ActionListener listener4 = new MappaListener();
		mappaCheckBox.addActionListener(listener4);
		
		return mappaCheckBox;
	}
	
	public JPanel createRangePanel() {
		JPanel panel = new JPanel();
		panel.add(createRangeButton());
		panel.add(createFieldPanel());
		
		return panel;
	}
	
	public JPanel createNazionePanel() {
		JPanel panel = new JPanel();
		panel.add(createNazioneButton());
		panel.add(createNazioneField());
		
		return panel;
	}
	
	public JRadioButton createNazioneButton() {
		nazioneButton = new JRadioButton();
		
		class NazioneListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				if(nazioneButton.isSelected()) {
					class CriterioNazione implements Criterio<CentroUrbanoMappa>{
						public boolean useCriterio(CentroUrbanoMappa item) {
							if(item.getNazione().getNome().equals(nazioneField.getText()))
								return true;
							else
								return false;
						}
					}
					Criterio<CentroUrbanoMappa> criterioNazione = new CriterioNazione();
					centri.setCriterio(criterioNazione);
					textArea.append(centri.getCentriByCriterio().toString());
					textArea.append("\n");
				}
			}
		}
		
		ActionListener listener3 = new NazioneListener();
		nazioneButton.addActionListener(listener3);
		
		return nazioneButton;
	}

	public JRadioButton createVisualizzaButton() {
		visualizzaButton = new JRadioButton("Visualizza");

		class VisualizzaListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (visualizzaButton.isSelected()) {
					class CriterioVero implements Criterio<CentroUrbanoMappa> {
						public boolean useCriterio(CentroUrbanoMappa item) {
							return true;
						}
					}
					Criterio<CentroUrbanoMappa> criterioVero = new CriterioVero();
					centri.setCriterio(criterioVero);
					textArea.append(centri.getCentriByCriterio().toString());
					textArea.append("\n");
				}
			}
		}

		ActionListener listener = new VisualizzaListener();
		visualizzaButton.addActionListener(listener);
		
		return visualizzaButton;
	}
	
	public JRadioButton createRangeButton() {
		rangeButton = new JRadioButton("Range");
		
		class RangeListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (rangeButton.isSelected()) {
					class CriterioRangeAbitanti implements Criterio<CentroUrbanoMappa>{
						public boolean useCriterio(CentroUrbanoMappa item) {
							if(item.getAbitanti() >= Integer.parseInt(range1Field.getText())&& item.getAbitanti() <= Integer.parseInt(range2Field.getText()))
								return true;
							else
								return false;
						}
					}
					Criterio<CentroUrbanoMappa> criterioRange = new CriterioRangeAbitanti();
					centri.setCriterio(criterioRange);
					textArea.append(centri.getCentriByCriterio().toString());
					textArea.append("\n");
				}
			}
		}
		
		ActionListener listener1 = new RangeListener();
		rangeButton.addActionListener(listener1);
		
		return rangeButton;
	}
	
	public JPanel createFieldPanel() {
		JPanel panel = new JPanel();
		JLabel range1Label = new JLabel("Minimo");
		range1Field = new JTextField(10);
		range1Field.setText("0");
		JLabel range2Label = new JLabel("Massimo");
		range2Field = new JTextField(10);
		range2Field.setText("0");
		
		panel.add(range1Label);
		panel.add(range1Field);
		panel.add(range2Label);
		panel.add(range2Field);
		
		return panel;
	}
	
	public JPanel createNazioneField() {
		JPanel panel = new JPanel();
		JLabel nazioneLabel = new JLabel("Nazione");
		nazioneField = new JTextField(10);
		nazioneField.setText("Italia");
		
		panel.add(nazioneLabel);
		panel.add(nazioneField);
		
		return panel;
	}
}
