package it.unisa.parole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	private BufferedReader reader;
	private Strategy s;
	private Contatore<?> c;
	
	public Console(Strategy s, Contatore<?> c) {
		reader = new BufferedReader(new InputStreamReader(System.in));
		this.s = s;
		this.c = c;
	}
	
	public void finalize() {
		if(reader != null) {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void chiediStringa() {
		String tmp;
		try {
			System.out.println("Inserire una riga: ");
			tmp = reader.readLine();
			s.append(tmp);
			System.out.println("Risultato conteggio = " + c.conta(tmp));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
