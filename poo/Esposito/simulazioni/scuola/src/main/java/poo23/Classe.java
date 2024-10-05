package poo23;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private String nome;
    private List<Docente> docenti;
    private List<Studente> studenti;
    
    public Classe(String nome) {
        this.nome = nome;
        docenti = new ArrayList<>();
        studenti = new ArrayList<>();
    }

    public List<Docente> getDocenti() {
        return docenti;
    }

    public void setDocenti(List<Docente> docenti) {
        this.docenti = docenti;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    public void aggiungiDocente(Docente ... docente){
        for(Docente d : docente)
            docenti.add(d);
    }

    public void aggiungiStudente(Studente ... studente){
        for(Studente s : studente)
            studenti.add(s);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Classe [nome=" + nome + "\n\t, docenti=" + docenti + "\n\t, studenti=" + studenti + "]\n\n";
    }

    


    
}
