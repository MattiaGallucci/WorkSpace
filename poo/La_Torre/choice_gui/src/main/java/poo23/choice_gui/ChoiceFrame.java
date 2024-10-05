package poo23.choice_gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class ChoiceFrame extends JFrame {
	private JLabel sampleField;
	
	private JCheckBox italicCheckBox;
	private JCheckBox boldCheckBox;
	
	private JRadioButton smallButton;
	private JRadioButton mediumButton;
	private JRadioButton largeButton;
	
	private JComboBox<String> facenameCombo;
	
	private ActionListener listener;

	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
	
	public ChoiceFrame() {
		sampleField = new JLabel("Ti amone");
		add(sampleField, BorderLayout.CENTER);
		
		class ChoiceListener implements ActionListener{
			public void actionPerformed(ActionEvent event) {
				setSampleFont();
			}
		}
		
		listener = new ChoiceListener();
		JPanel controlPanel = createControlPanel();
		add(controlPanel, BorderLayout.SOUTH);
		setSampleFont();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	public JPanel createControlPanel() {
		JPanel facenamePanel = createComboBox();
		JPanel sizegroupPanel = createCheckBoxes();
		JPanel styleGroupPanel = createRadioButtons();
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3, 1));
		controlPanel.add(facenamePanel);
		controlPanel.add(sizegroupPanel);
		controlPanel.add(styleGroupPanel);
		
		return controlPanel;
	}
	
	public JPanel createComboBox() {
		facenameCombo = new JComboBox<String>();
		facenameCombo.addItem("Serif");
		facenameCombo.addItem("SansSerif");
		facenameCombo.addItem("Monospaced");
		facenameCombo.setEditable(false);
		facenameCombo.addActionListener(listener);
		
		JPanel panel = new JPanel();
		panel.add(facenameCombo);
		
		return panel;
	}
	
	public JPanel createCheckBoxes() {
		italicCheckBox = new JCheckBox("Italic");
		italicCheckBox.addActionListener(listener);
		
		boldCheckBox = new JCheckBox("Bold");
		boldCheckBox.addActionListener(listener);
		
		JPanel panel = new JPanel();
		panel.add(italicCheckBox);
		panel.add(boldCheckBox);
		panel.setBorder(new TitledBorder( new EtchedBorder(), "Style") );
		
		return panel;
	}
	
	public JPanel createRadioButtons() {
		smallButton = new JRadioButton("Small");
		smallButton.addActionListener(listener);
		
		mediumButton = new JRadioButton("Medium");
		mediumButton.addActionListener(listener);
		
		largeButton = new JRadioButton("Large");
		largeButton.addActionListener(listener);
		largeButton.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(smallButton);
		group.add(mediumButton);
		group.add(largeButton);
		
		JPanel panel = new JPanel();
		panel.add(smallButton);
		panel.add(mediumButton);
		panel.add(largeButton);
		panel.setBorder(new TitledBorder( new EtchedBorder(), "Size"));
		
		return panel;
	}
	
	public void setSampleFont() {
		String facename = (String) facenameCombo.getSelectedItem();
		
		int style = 0;
		
		if(italicCheckBox.isSelected())
			style += Font.ITALIC;
		if(boldCheckBox.isSelected())
			style += Font.BOLD;
		
		int size = 0;
		final int SMALL_SIZE = 24;
		final int MEDIUM_SIZE = 36;
		final int LARGE_SIZE = 48;
		
		if(smallButton.isSelected())
			size = SMALL_SIZE;
		else if(mediumButton.isSelected())
			size = MEDIUM_SIZE;
		else if(largeButton.isSelected())
			size = LARGE_SIZE;
		
		sampleField.setFont(new Font(facename, style, size));
		sampleField.repaint();
	}
}
