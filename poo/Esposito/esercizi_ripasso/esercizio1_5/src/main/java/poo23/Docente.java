package poo23;

import java.util.List;

public class Docente extends Persona{
    List<Materia> materieInsegnate;

    public Docente(String nome, String cognome, String codiceFiscale, List<Materia> materieInsegnate) {
        super(nome, cognome, codiceFiscale);
        this.materieInsegnate = materieInsegnate;
    }
}
