package poo23;

public class Studente extends Persona{
    private Classe classe;

    public Studente(String nome, String cognome, String cf, Classe classe) {
        super(nome, cognome, cf);
        this.classe = classe;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

}
