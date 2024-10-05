package poo23.tutor_28_11_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
	public static void main(String[] args) {
		Concessionaria concessionaria = null;
		Moto moto1 = new Moto("MOTO", "modello", 2000, 3000);

		File f = new File("in.dat");

		if (f.exists() && !f.isDirectory()) {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
				concessionaria = (Concessionaria) in.readObject();
				System.out.println(concessionaria);
				in.close();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			concessionaria = new Concessionaria("Ciao");
			concessionaria.aggiungiVeicolo(new Auto("AAA", "ABA", 30000, 5));
			concessionaria.aggiungiVeicolo(new Auto("BBB", "ACA", 20000, 5));
			concessionaria.aggiungiVeicolo(new Auto("CCC", "ADA", 50000, 5));
		}

	}
}
