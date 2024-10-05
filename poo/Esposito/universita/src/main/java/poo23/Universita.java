package poo23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Universita {
    private HashMap<String, List<?>> universita;

    public Universita(){ universita = new HashMap<>(); }
    public void aggiungi (String nome, List<?> lista) { universita.put(nome, lista); }
    public List<?> getList (String nome) { return universita.get(nome); }

    /*public void stampaDocenti(Universita universita, String classe){
        List<?> temp = new ArrayList<>();
        temp = universita.getList(classe);
        @SuppressWarnings("unchecked")
        List<Docente> doc = (List<Docente>) temp.get(0);
        for (Docente docente : doc)
            System.out.println(docente);
    }

    public void stampaStudenti(Universita universita, String classe){
        List<?> temp = new ArrayList<>();
        temp = universita.getList(classe);
        @SuppressWarnings("unchecked")
        List<Studente> stud = (List<Studente>) temp.get(1);
        for (Studente studente : stud)
            System.out.println(studente);
    }*/

    public void stampaPersone(Universita universita, String classe, Class<?> tipoPersona) {
        List<?> temp = universita.getList(classe);
        List<?> persone = (List<?>) temp.get(tipoPersona == Docente.class ? 0 : 1);
    
        for (Object persona : persone) {
            System.out.println(persona);
        }
    }
    

    public void votoMaggiore(Universita universita, String classe, int voto){
        List<?> temp = new ArrayList<>();
        temp = universita.getList(classe);
        @SuppressWarnings("unchecked")
        List<Studente> stud = (List<Studente>) temp.get(1);
        for (Studente studente : stud)
            if (studente.getVoto() > voto)
                System.out.println(studente);
    }

}