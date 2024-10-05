package poo23.tutor_07_12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;

public class App {
	public static void main(String[] args) {
		File file = new File("magazzino.dat");
		Magazzino magazzino = null;

		if (file.exists()) {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
				magazzino = (Magazzino) in.readObject();
				in.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			magazzino = new Magazzino();
			Prodotto p1 = new Prodotto("Nutella", 10, 7);
			Prodotto p2 = new Prodotto("Biscotti", 5, 5);
			Prodotto p3 = new Prodotto("Latte", 7, 3);
			Prodotto p4 = new Prodotto("Posate", 24, 5);
			Prodotto p5 = new Prodotto("Bottiglia", 3, 1);
			try {
				magazzino.aggiungiProdotto(p1);
				magazzino.aggiungiProdotto(p2);
				magazzino.aggiungiProdotto(p3);
				magazzino.aggiungiProdotto(p4);
				magazzino.aggiungiProdotto(p5);
			} catch (ItemAlreadyPresentException e) {
				System.out.println(e.getMessage());
			}
		}
		
		JFrame magazzinoFrame = new MagazzinoFrame(magazzino);
		magazzinoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		magazzinoFrame.setVisible(true);
	}
}
