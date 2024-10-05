package poo23;

import java.util.ArrayList;
import java.util.List;

public class Docente {
    private String nome;
    private Materia materia;
    private List<Classe> classi;
    
    public Docente(String nome, Materia materia) {
        this.nome = nome;
        this.materia = materia;
        classi = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public List<Classe> getClassi() {
        return classi;
    }

    public void setClassi(List<Classe> classi) {
        this.classi = classi;
    }

    public void aggiungiClasse(Classe ... classe) {
        for(Classe c : classe)
            classi.add(c);
    }

    @Override
    public String toString() {
        return "Docente [nome=" + nome + ", materia=" + materia + "]";
    }
    
}
