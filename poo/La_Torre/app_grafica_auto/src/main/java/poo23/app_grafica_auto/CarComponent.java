package poo23.app_grafica_auto;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class CarComponent extends JComponent {
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Car car1 = new Car(0, 0);

		int x = getWidth() - Car.WIDTH;
		int y = getHeight() - Car.HEIGHT;
		Car car2 = new Car(x, y);

		car1.disegna(g2);
		car2.disegna(g2);
	}
}
