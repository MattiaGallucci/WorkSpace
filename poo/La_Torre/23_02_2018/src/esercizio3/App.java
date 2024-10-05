package esercizio3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;

import esercizio1.Coppia;
import esercizio1.DivanoLetto;
import esercizio1.Letto;

public class App {
	public static void main(String[] args) {
		ArrayList<Letto> letti = new ArrayList<Letto>();
		Letto l1 = new Letto("1", new Coppia<Integer>(3, 3), null);
		Letto l2 = new Letto("2", new Coppia<Integer>(3, 2), null);
		Letto l3 = new Letto("3", new Coppia<Integer>(5, 2), null);
		letti.add(l1);
		letti.add(l2);
		letti.add(l3);
		
		ArrayList<DivanoLetto> divanoletti = new ArrayList<DivanoLetto>();
		DivanoLetto dl1 = new DivanoLetto("4", new Coppia<Integer>(2, 2), 0, true, new Coppia<Integer>(2, 2));
		DivanoLetto dl2 = new DivanoLetto("5", new Coppia<Integer>(0, 0), 0, false, null);
		DivanoLetto dl3 = new DivanoLetto("6", new Coppia<Integer>(3, 4), 0, true, new Coppia<Integer>(3, 4));
		DivanoLetto dl4 = new DivanoLetto("7", new Coppia<Integer>(2, 5), 0, true, new Coppia<Integer>(2, 5));
		divanoletti.add(dl1);
		divanoletti.add(dl2);
		divanoletti.add(dl3);
		divanoletti.add(dl4);
		
		ArrayList<String> stringList = null;
		
		File f = new File("prova.dat");
		
		if(f.exists()) {
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
				stringList = (ArrayList<String>) in.readObject();
				in.close();
			}catch (IOException | ClassNotFoundException  e) {
				e.getMessage();
			}
		} else {
			stringList = new ArrayList<String>();
			stringList.add("quattro");
			stringList.add("casa");
			stringList.add("televisione");
			stringList.add("armadio");
			stringList.add("castello");
			stringList.add("piramide");
			stringList.add("anello");
			
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
				out.writeObject(stringList);
				out.close();
			} catch(IOException e) {
				e.getMessage();
			}
		}
		
		JFrame frame = new CreaFrame(stringList, letti, divanoletti);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}