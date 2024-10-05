package poo23.tutor_21_11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Libreria libreria = new Libreria();
		Libro libro1 = new Libro("Ciao", "Io", 2000);
		Libro libro2 = new Libro("Mondo", "Io", 2000);
		Libro libro3 = new Libro("Ciao", "Io", 2000);
		File f = new File("FILE1.dat");

		try {
			libreria.aggiungiLibro(libro1);
			libreria.aggiungiLibro(libro2);
			// libreria.aggiungiLibro(libro3);
		} catch (LibroDuplicatoException e) {
			System.out.println(e);
		}

		if (f.exists() && f.isDirectory()) {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
				Libreria lib = (Libreria) in.readObject();
				in.close();
			} catch (IOException e) {
				System.out.println(e);
			} finally {
				System.out.println("Grazie");
			}
		}

		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("FILE2.dat"));
		//out.writeObject(lib);
		out.close();
	}
}
