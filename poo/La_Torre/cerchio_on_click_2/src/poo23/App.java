package poo23;

import javax.swing.JFrame;

public class App {
	public static void main(String[] args) {
		RaggioFrame inputFrame = new RaggioFrame();
		inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputFrame.setVisible(true);
		CerchioFrame frame = new CerchioFrame(inputFrame);
		frame.setVisible(true);
	}
}