package it.unisa.scuola;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Studente extends Persona {
	private String matricola;
	private List<Votazione> voti;

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public void addVoto(Votazione voto) {
		voti.add(voto);
	}
	
	public Votazione getVotoByDate(Date date) {
		Iterator<Votazione> iterator = voti.iterator();
	    while (iterator.hasNext()) {
	    	Votazione voto = iterator.next();
	        if (voto.getData().equals(date)) {
	            return voto;
	        }
	    }
	    return null;  
	}
	
	public List<Votazione> getVotiBySubject(String materia) {
		List<Votazione> voti_4_subject = new ArrayList<>();
		Iterator<Votazione> iterator = voti.iterator();
	    while (iterator.hasNext()) {
	    	Votazione voto = iterator.next();
	        if (voto.getDocente().getMateria().equals(materia)) {
	        	voti_4_subject.add(voto);
	        }
	    }
	    return voti_4_subject;  
	}

	public Studente(String cF, String nome, String cognome, String matricola) {
		super(cF, nome, cognome);
		this.matricola = matricola;
		voti = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", " + super.toString() + ", voti=" + voti + "]";
	}
	
	public double average() {
		double mean = 0.0;
		if(voti.size() != 0) {			
			Iterator<Votazione> iterator = voti.iterator();
		    while (iterator.hasNext()) {
		    	Votazione voto = iterator.next();
		    	mean += voto.getVoto();
		    }
		    mean = mean / voti.size();
		}
	    return mean;  
	}
}
