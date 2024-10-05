package esercizio3;

import esercizio1.Cliente;
import esercizio2.EmptyListException;
import esercizio2.KeyList;

public class App {
	public static void main(String[] args) {
		KeyList<String> lista = new KeyList<>();

		
		
		Cliente c1 = new Cliente("Mattia", null);
		try{
		lista.rimuovi(c1.getKey());
		}catch(EmptyListException e){
			System.out.println(e);
		}
		Cliente c2 = new Cliente("Chicca", null);
		Cliente c3 = new Cliente("Ciccio", null);
		Cliente c4 = new Cliente("Mattia", null);
		
		lista.aggiungi(c1);
		lista.aggiungi(c2);
		lista.aggiungi(c3);
		lista.aggiungi(c4);
		
		System.out.println("Lista prima della rimozione di Mattia:" + lista);
		/*try {
			lista.rimuovi("Mattia");
		}catch (EmptyListException e) {
			System.out.println("Lista vuota");
		}*/
		System.out.println(lista);
		
	}
}