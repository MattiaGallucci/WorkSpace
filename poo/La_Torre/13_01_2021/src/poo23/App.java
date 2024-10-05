package poo23;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

public class App {
	public static void main(String[] args) {
		ClienteOrdinario cliente1 = new ClienteOrdinario("Mattia", 20);
		ClienteOro cliente2 = new ClienteOro("Chicca");
		int prezzo = 100;
		
		List<Cliente> clienti = Arrays.asList(cliente1, cliente2);
		
		JFrame frame = new ClienteFrame(clienti);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}