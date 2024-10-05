package poo23;

import javax.swing.JFrame;

public class App {
	public static void main(String[] args) {
		CollezioneClienti<String> clienti = new CollezioneClienti();
		Cliente c1 = new Cliente(new Indirizzo(null, 0, null, 0), "Mattia");
		Cliente c2 = new Cliente(new Indirizzo(null, 0, null, 0), "Chicca");
		Cliente c3 = new Cliente(new Indirizzo(null, 0, null, 0), "Ciccio");
		
		clienti.aggiungi(c1);
		clienti.aggiungi(c2);
		clienti.aggiungi(c3);
		
		System.out.println(clienti);
		
		/*JFrame frame = new CollezioneFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);*/
	}
}