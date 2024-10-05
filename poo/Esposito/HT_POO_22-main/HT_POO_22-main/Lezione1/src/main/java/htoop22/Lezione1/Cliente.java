package htoop22.Lezione1;

import java.util.ArrayList;

public class Cliente {
	private int id;
	private String nome;
	private String cognome;
	private ArrayList<Ordine> ordini;
	
	public Cliente(int id, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.ordini = new ArrayList<Ordine>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public ArrayList<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(ArrayList<Ordine> ordini) {
		this.ordini = ordini;
	}
	
	public void addOrdine(Ordine o) {
		this.ordini.add(o);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	

}
