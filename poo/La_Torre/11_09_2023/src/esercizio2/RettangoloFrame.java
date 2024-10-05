package esercizio2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RettangoloFrame extends JFrame{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
	private JPanel controlPanel;
		private JPanel buttonPanel;
			private JButton disegnaButton;
		private JPanel parametriPanel;
			private JPanel xPanel;
				private JLabel xLabel;
				private JTextField xField;
			private JPanel yPanel;
				private JLabel yLabel;
				private JTextField yField;
			private JPanel wPanel;
				private JLabel wLabel;
				private JTextField wField;
			private JPanel hPanel;
				private JLabel hLabel;
				private JTextField hField;
				
	private RettangoloComponent rettangolo;
	
	public RettangoloFrame() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		add(createControlPanel(), BorderLayout.NORTH);
		rettangolo = new RettangoloComponent(0, 0, 0, 0);
		
		class MousePressListener implements MouseListener{
			public void mousePressed(MouseEvent e) {
				int x = e.getX();	
				int y = e.getY();
				int w = Integer.parseInt(wField.getText());
				int h = Integer.parseInt(hField.getText());
				rettangolo.moveTo(x, y, w, h);
				repaint();
				revalidate();
			}
			
			public void mouseClicked(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		}

		MouseListener listener = new MousePressListener();
		rettangolo.addMouseListener(listener);
		
		add(rettangolo);
	}
	
	public JPanel createControlPanel() {
		controlPanel = new JPanel();
		controlPanel.add(createButtonPanel());
		controlPanel.add(createParametriPanel());
		
		return controlPanel;
	}
	
	public JPanel createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.add(createDisegnaButton());
		
		return buttonPanel;
	}
	
	public JButton createDisegnaButton() {
		disegnaButton = new JButton("Disegna");
		
		class DisegnaListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(xField.getText());
				int y = Integer.parseInt(yField.getText());
				int w = Integer.parseInt(wField.getText());
				int h = Integer.parseInt(hField.getText());
				
				add(new RettangoloComponent(x, y, w, h));
				repaint();
				revalidate();
			}
		}
		
		ActionListener listener = new DisegnaListener();
		disegnaButton.addActionListener(listener);
		
		return disegnaButton;
	}
	
	public JPanel createParametriPanel() {
		parametriPanel = new JPanel();
		parametriPanel.setLayout(new GridLayout(2, 2));
		parametriPanel.add(createXPanel());
		parametriPanel.add(createYPanel());
		parametriPanel.add(createWPanel());
		parametriPanel.add(createHPanel());
		
		return parametriPanel;
	}
	
	public JPanel createXPanel() {
		xPanel = new JPanel();
		xLabel = new JLabel("X:");
		xField = new JTextField(5);
		xField.setText("0");
		
		xPanel.add(xLabel);
		xPanel.add(xField);
		
		return xPanel;
	}
	
	public JPanel createYPanel() {
		yPanel = new JPanel();
		yLabel = new JLabel("Y:");
		yField = new JTextField(5);
		yField.setText("0");
		
		yPanel.add(yLabel);
		yPanel.add(yField);
		
		return yPanel;
	}
	
	public JPanel createWPanel() {
		wPanel = new JPanel();
		wLabel = new JLabel("Width:");
		wField = new JTextField(5);
		wField.setText("0");
		
		wPanel.add(wLabel);
		wPanel.add(wField);
		
		return wPanel;
	}
	
	public JPanel createHPanel() {
		hPanel = new JPanel();
		hLabel = new JLabel("Height:");
		hField = new JTextField(5);
		hField.setText("0");
		
		hPanel.add(hLabel);
		hPanel.add(hField);
		
		return hPanel;
	}
}