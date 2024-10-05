package poo23.tutor_28_11_1;

import java.util.ArrayList;
import java.util.List;

public class Concessionaria {
	private List<Deteriorabile> concessionario;
	private String nome;

	public Concessionaria(String nome) {
		concessionario = new ArrayList<>();
		this.nome = nome;
	}
	
	/*public void aggiungiVeicolo(Veicolo veicolo){
		if(! (veicolo instanceof Deteriorabile))
			throw new VeicoloNonDeteriorabileException();
		concessionario.add((Deteriorabile) veicolo);
	}*/
	
	public  <T extends Deteriorabile>  void aggiungiVeicolo (T veicolo) {
		concessionario.add(veicolo);
	}
	
	public Deteriorabile getMaxDeteriorato() {
		Deteriorabile max = concessionario.get(0);
		
		for(Deteriorabile veicolo : concessionario)
			if(max.getStatoDeterioramento() < veicolo.getStatoDeterioramento())
				max = veicolo;
		
		return max;
	}

	public String toString() {
		return "Concessionaria [concessionario=\n" + concessionario + ", nome=" + nome + "]";
	}
	
}
