package esercizio1;

import java.util.ArrayList;

public class Cargo extends Velivolo{
	private ArrayList<Integer> vani;

	public Cargo(String codice, int pesoMassimo, Certificato certificato, int numeroVani) {
		super(codice, pesoMassimo, certificato);
		vani = new ArrayList<Integer>(numeroVani);
	}
	
}
