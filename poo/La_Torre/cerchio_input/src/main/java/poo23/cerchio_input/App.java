package poo23.cerchio_input;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class App {
	private static final int FRAME_WIDTH = 300;
	private static final int FRAME_HEIGHT = 400;
    
	public static void main( String[] args ){
    	JFrame frame = new JFrame();
    	
    	String input;
		input = JOptionPane.showInputDialog("rosso");
		float rosso = Float.parseFloat(input);
		input = JOptionPane.showInputDialog("verde");
		float verde = Float.parseFloat(input);
		input = JOptionPane.showInputDialog("blu");
		float blu = Float.parseFloat(input);
		
		Color fillColor = new Color(rosso, verde, blu);
    	
		CerchioComponent component = new CerchioComponent(fillColor);
		frame.add(component);
		
    	frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
    }
}
