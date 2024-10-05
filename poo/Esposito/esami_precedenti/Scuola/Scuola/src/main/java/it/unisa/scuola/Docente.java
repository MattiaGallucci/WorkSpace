package it.unisa.scuola;

public class Docente extends Persona {
	private String materia;
	private Classe classe;

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Docente(String cF, String nome, String cognome, String materia) {
		super(cF, nome, cognome);
		this.materia = materia;
		this.classe = null;
	}

	@Override
	public String toString() {
		return "Docente [materia=" + materia + ", " + super.toString() + "]";
	}
}
