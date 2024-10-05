package esercizio1;

import java.awt.Rectangle;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(0, 0, 5, 4);
		Rectangle r2 = new Rectangle(0, 0, 4, 4);
		Rectangle r3 = new Rectangle(0, 0, 5, 5);
		Rectangle r4 = new Rectangle(0, 0, 10, 10);
		ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
		rectangleList.add(r1);
		rectangleList.add(r2);
		rectangleList.add(r3);
		rectangleList.add(r4);
		
		Criterio<Rectangle> criterioRettangoli = new Criterio<Rectangle>() {
			public boolean seleziona(Rectangle item) {
				if(item.width * item.height >= 20)
					return true;
				else
					return false;
			}
		};
		
		Algoritmo algoritmoRettangoli = new Algoritmo();
		System.out.println(algoritmoRettangoli.applica(rectangleList, criterioRettangoli));
	}

}
