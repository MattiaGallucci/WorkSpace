package poo23.app_grafica_auto;

import javax.swing.JFrame;

public class CarViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 300;
		final int FRAME_HEIGHT = 400;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setTitle("2 auto");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CarComponent component = new CarComponent();
		frame.add(component);
		frame.setVisible(true);
	}
}
