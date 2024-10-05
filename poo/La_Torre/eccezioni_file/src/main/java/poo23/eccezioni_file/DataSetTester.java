package poo23.eccezioni_file;

import java.io.*;
import java.util.Scanner;

public class DataSetTester {
	public static void main(String[] args) {
		DataSetReader reader = new DataSetReader();
		boolean done = false;
		Scanner in = new Scanner(System.in);

		while (!done) {
			try {
				System.out.println("Nome del file?");
				
				String filename = in.next();
				double[] data = reader.readFile(filename);
				double sum = 0;

				for (double d : data)
					sum += d;
				
				System.out.println("La somma è " + sum);
				done = true;

			} catch (FileNotFoundException e) {
				System.out.println("File inesistente, nome?");
			} catch (BadDataException e) {
				System.out.println("Bad data: " + e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		in.close();
	}
}
