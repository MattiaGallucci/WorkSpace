package poo23.eccezioni;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		double res;
		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci il numeratore: ");
		int n = in.nextInt();

		System.out.print("Inserisci il denominatore: ");
		int d = in.nextInt();

		try {
			Divisione div = new Divisione(n, d);
			res = div.dividi();
			System.out.println(res);
		} catch (DivisionePerZeroException exception) {
			System.out.println(exception);
			//exception.printStackTrace();
		}
		System.out.println("CIAO");
		in.close();
	}
}
