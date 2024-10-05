package it.unisa.covid;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CentroVaccinale {
	private String nome;
	private List<Vaccinato> lista;
	
	public CentroVaccinale(String nome) {
		this.nome = nome;
		lista = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}

	public void insert(Vaccinato elem) {
		lista.add(elem);
	}
	
	public Vaccinato get(String cf) {
		int pos = lista.indexOf(new Vaccinato(cf, null, null, 0));
		return lista.get(pos);
	}
	
	public int elements() {
		return lista.size();
	}
	
	public void saveOnFile(String nome) {
		StringBuffer buf = new StringBuffer();
		for(Vaccinato elem : lista) {
			buf.append(elem.toString());
		}
		try {
            Files.write(Paths.get(nome), buf.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
