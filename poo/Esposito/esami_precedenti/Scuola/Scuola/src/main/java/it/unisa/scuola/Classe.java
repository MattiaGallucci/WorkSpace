package it.unisa.scuola;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Classe {
	private List<Studente> studenti;
	private List<Docente> docenti;
	private String nome;
	
	public Classe(String nome) {
		super();
		this.nome = nome;
		studenti = new ArrayList<>();
		docenti = new ArrayList<>();
	}
	
	public void putStudente(Studente studente) {
		studenti.add(studente);
	}
	
	public boolean hasStudente(String CF) {
		return getStudente(CF) != null;
	}
	
	public Studente getStudente(String CF) {
		Iterator<Studente> iterator = studenti.iterator();
	    while (iterator.hasNext()) {
	    	Studente studente = iterator.next();
	        if (studente.getCF().equals(CF)) {
	            return studente;
	        }
	    }
	    return null;  
	}
	
	public void putDocente(Docente docente) throws Exception {
		if(docente.getClasse() == null) {
			docenti.add(docente);
			docente.setClasse(this);
		} else
			throw new Exception("Non inseribile in due clsse");
	}
	
	public boolean hasDocente(String CF) {
		return getDocente(CF) != null;
	}
	
	public Docente removeDocente(String CF) {
		Docente doc = this.getDocente(CF);
		if(doc != null) {
			docenti.remove(doc);
			doc.setClasse(null);
		}
		return doc;
	}
	
	public Docente getDocente(String CF) {
		Iterator<Docente> iterator = docenti.iterator();
	    while (iterator.hasNext()) {
	    	Docente docente = iterator.next();
	        if (docente.getCF().equals(CF)) {
	            return docente;
	        }
	    }
	    return null;  
	}
	
	public String getNome() {
		return this.nome;
	}

	@Override
	public String toString() {
		return "Classe [nome=" + nome + ", studenti=" + studenti + ", docenti=" + docenti + "]";
	}
	
	public double average() {
		double mean = 0.0;
		if(studenti.size() != 0) {			
			Iterator<Studente> iterator = studenti.iterator();
		    while (iterator.hasNext()) {
		    	Studente studente = iterator.next();
		    	mean += studente.average();
		    }
		    mean = mean / studenti.size();
		}
	    return mean;  
	}
}
