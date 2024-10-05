package it.unisa.scuola;

import java.util.Date;

public class Votazione {
	private Docente docente;
	private Double voto;
	private Date data;
	
	public Votazione(Docente docente, Double voto, Date data) {
		super();
		this.docente = docente;
		this.voto = voto;
		this.data = data;
	}

	public Double getVoto() {
		return voto;
	}

	public void setVoto(Double voto) {
		this.voto = voto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Docente getDocente() {
		return docente;
	}

	@Override
	public String toString() {
		return "Votazione [docente=" + docente + ", voto=" + voto + ", data=" + data + "]";
	}
}
