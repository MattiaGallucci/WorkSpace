package poo23;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame extends JFrame{
	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	
	private JPanel control;
	private JPanel panel;
	private JPanel siPanel;
	private JPanel noPanel;
	private JLabel label;
	private JButton siButton;
	private JButton noButton;
	
	public TestFrame() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		control = new JPanel();
		panel = new JPanel();
		label = new JLabel("Chicca è piu bella di Mattia?");
		panel.add(label, BorderLayout.CENTER);
		
		control.setLayout(new BorderLayout());
		control.add(panel, BorderLayout.NORTH);
		control.add(createSi(), BorderLayout.WEST);
		control.add(createNo(), BorderLayout.EAST);
		
		add(control);
	}
	
	public JPanel createSi() {
		siPanel = new JPanel();
		siButton = new JButton("SI");
		
		class Listener implements MouseListener{
			public void mouseClicked(java.awt.event.MouseEvent e) {
			}
			public void mousePressed(java.awt.event.MouseEvent e) {
			}
			public void mouseReleased(java.awt.event.MouseEvent e) {
			}
			public void mouseEntered(java.awt.event.MouseEvent e) {
				Random x = new Random();
				Random y = new Random();
				siPanel.setLocation(x.nextInt(500), y.nextInt(500));
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
			}
		}
		MouseListener listener = new Listener();
		siButton.addMouseListener(listener);
		
		siPanel.add(siButton, BorderLayout.CENTER);
		return siPanel;
	}
	
	public JPanel createNo() {
		noPanel = new JPanel();
		noButton = new JButton("NO");
		
		class NoL implements ActionListener{

			public void actionPerformed(ActionEvent e) {
				JFrame frame = new VittoriaFrame();
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		
		ActionListener listener = new NoL();
		noButton.addActionListener(listener);
		
		noPanel.add(noButton, BorderLayout.CENTER);
		
		return noPanel;
	}
}