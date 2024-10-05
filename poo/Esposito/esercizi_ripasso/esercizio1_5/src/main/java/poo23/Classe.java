package poo23;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    private String nome;
    private List<Studente> studenti;

    public Classe(String nome) {
        this.nome = nome;
        this.studenti = new ArrayList<>();
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    
}
