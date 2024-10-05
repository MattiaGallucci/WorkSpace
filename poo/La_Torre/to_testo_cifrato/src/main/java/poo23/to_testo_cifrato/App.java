package poo23.to_testo_cifrato;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* X <- M+3 mod 26 */

public class App {
	public static void main(String[] args) {
		try {
			FileReader in = new FileReader("FILE1.txt");
			PrintWriter out = new PrintWriter("FILE2.txt");
			Scanner sc = new Scanner(in);

			while (sc.hasNext()) {
				String parola = sc.nextLine();
				out.print(cifraTesto(parola.toUpperCase()) + " ");
			}

			out.close();
			sc.close();
		} catch (IOException exception) {
			System.out.println("Error processing file:" + exception);
		}
	}

	public static String cifraTesto(String parola) {
		StringBuilder parola_cifrata = new StringBuilder();
		for (int i = 0; i < parola.length(); i++) {
			char c = parola.charAt(i);
			if (c != ' ') {
				c = (char) ((char) (c + 3) % 91);
				if (c < 65)
					c += 65;
			}
			parola_cifrata.append(c);
		}
		return parola_cifrata.toString();
	}
}
