package poo23.tutor_07_12;

import java.io.Serializable;

public class Prodotto implements Serializable{
	private static final long serialVersionUID = 1L;
	private String nome;
	private int quantita;
	private int prezzo;

	public Prodotto(String nome, int quantita, int prezzo) {
		this.nome = nome;
		this.quantita = quantita;
		this.prezzo = prezzo;
	}
	
	public boolean equals(Object other) {
		if(this == other)
			return true;
		if (other == null || getClass() != other.getClass()) 
            return false;
		Prodotto o = (Prodotto) other;
		
		if(nome == o.nome)
			return true;
		return false;
	}

	public String toString() {
		return "Prodotto [nome=" + nome + ", quantita=" + quantita + ", prezzo=" + prezzo + "]";
	}

}
