package poo23;

import java.util.List;

public class Docente {
    String nome;
    String cognome;
    String materia;
    List<Classe> classi;
    
    public Docente(String nome, String cognome, String materia, List<Classe> classi) {
        this.nome = nome;
        this.cognome = cognome;
        this.materia = materia;
        this.classi = classi;
    }
}
