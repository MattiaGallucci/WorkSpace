package poo23;

import java.util.List;

public class Classe {
    private List<Studente> studenti;
    private List<Docente> docenti;

    public Classe(List<Studente> studenti, List<Docente> docenti) {
        this.studenti = studenti;
        this.docenti = docenti;
    }

    public void aggiungi(List<Studente> studenti, List<Docente> docenti){
        this.studenti = studenti;
        this.docenti = docenti;
    }

    public List<Studente> getStudenti(){
        return studenti;
    }

    public List<Docente> getDocenti() {
        return docenti;
    }
    
}
