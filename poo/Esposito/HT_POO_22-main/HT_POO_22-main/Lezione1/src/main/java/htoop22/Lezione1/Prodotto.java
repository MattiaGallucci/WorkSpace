package htoop22.Lezione1;

import java.util.Objects;

public class Prodotto implements Cloneable{

	private String nome;
	private double prezzo;
	private String marca;
	private int qta;


	public Prodotto(String nome, double prezzo, String marca) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.marca = marca;
		this.qta = 1;
	}

	public Prodotto(String nome, double prezzo, String marca, int qta) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.marca = marca;
		this.qta = qta;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getQta() {
		return qta;
	}

	public void setQta(int qta) {
		this.qta = qta;
	}
	
	

	@Override
	public String toString() {
		return this.getClass().toString() + " [nome=" + nome + ", prezzo=" + prezzo + ", marca=" + marca + ", qta=" + qta + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prodotto other = (Prodotto) obj;
		return this.getNome().equals(other.getNome());
	}

	public Object clone() {
		try {
			Object ogg = super.clone();
			return ogg;    
		}    
		catch(CloneNotSupportedException e ){
			return null;
		}
	}    



}
