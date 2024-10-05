package poo23;

import java.util.ArrayList;
import java.util.List;

public class Scuola {
    private List<Classe> classi;

    public Scuola() {
        classi = new ArrayList<>();
    }

    public List<Classe> getClassi() {
        return classi;
    }

    public void setClassi(List<Classe> classi) {
        this.classi = classi;
    }

    public void aggiungiClasse(Classe ... classe) {
        for (Classe c : classe) {
            classi.add(c);
        }
    }

    @Override
    public String toString() {
        return "Scuola [classi=" + classi + "]";
    }
    
}
