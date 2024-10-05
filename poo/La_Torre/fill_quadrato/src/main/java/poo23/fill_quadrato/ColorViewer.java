package poo23.fill_quadrato;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ColorViewer {
	public static void main(String [] args) {
		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 400;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String input;
		input = JOptionPane.showInputDialog("rosso");
		float rosso = Float.parseFloat(input);
		input = JOptionPane.showInputDialog("verde");
		float verde = Float.parseFloat(input);
		input = JOptionPane.showInputDialog("blu");
		float blu = Float.parseFloat(input);
		
		Color fillColor = new Color(rosso, verde, blu);
		ColoredSquareComponent component = new ColoredSquareComponent(fillColor);
		
		frame.add(component);
		
		frame.setVisible(true);
	}
}
