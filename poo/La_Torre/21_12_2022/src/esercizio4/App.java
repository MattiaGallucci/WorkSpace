package esercizio4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import javax.swing.JFrame;

import esercizio1.Nazione;
import esercizio3.Centri;
import esercizio2.CentroUrbanoMappa;
import esercizio2.PuntoMappa;

public class App {
	public static void main(String[] args) {
		File f = new File("collezione.dat");
		Centri<CentroUrbanoMappa> c;

		/*if (f.exists()) {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
				c = (Centri<CentroUrbano>) in.readObject();
				in.close();
			} catch (IOException | ClassNotFoundException e) {
				e.getMessage();
			}
		} else */{
			c = new Centri<>();
			
			Nazione italia = new Nazione("Italia", 0);
			Nazione spagna = new Nazione("Spagna", 0);
			
			CentroUrbanoMappa c1 = new CentroUrbanoMappa("milano", italia, 100000, 0, new PuntoMappa(10, 20));
			CentroUrbanoMappa c2 = new CentroUrbanoMappa("Roma", italia, 200000, 0, new PuntoMappa(30, 10));
			CentroUrbanoMappa c3 = new CentroUrbanoMappa("Napoli", italia, 300000, 0, new PuntoMappa(46, 55));
			CentroUrbanoMappa c4 = new CentroUrbanoMappa("Palermo", italia, 70000, 0, new PuntoMappa(110, 230));
			CentroUrbanoMappa c5 = new CentroUrbanoMappa("Cagliari", italia, 55000, 0, new PuntoMappa(30, 20));
			CentroUrbanoMappa c6 = new CentroUrbanoMappa("Salerno", italia, 80000, 0, new PuntoMappa(9, 77));
			CentroUrbanoMappa c7 = new CentroUrbanoMappa("BOH", spagna, 80000, 0, new PuntoMappa(9, 69));

			c.aggiungi(c1);
			c.aggiungi(c2);
			c.aggiungi(c3);
			c.aggiungi(c4);
			c.aggiungi(c5);
			c.aggiungi(c6);
			c.aggiungi(c7);
		}
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(c);
			out.close();
		} catch(IOException e) {
			e.getMessage();
		}
		
		JFrame frame = new VisualizzaFrame(c);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
