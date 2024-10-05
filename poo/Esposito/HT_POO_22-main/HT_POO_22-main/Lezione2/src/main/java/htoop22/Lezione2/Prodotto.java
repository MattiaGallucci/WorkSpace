package htoop22.Lezione2;

import java.lang.reflect.InvocationTargetException;
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
	
	public Prodotto(Prodotto p) {
		this.nome = new String(p.nome);
		this.prezzo = p.prezzo;
		this.marca = new String(p.marca);
		this.qta = p.qta;
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

	@SuppressWarnings("unchecked")
	public static <T> T clone(T original_obj) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return (T) original_obj.getClass().getConstructor(original_obj.getClass()).newInstance(original_obj);	
	}


}
