package poo23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Materia {
    private String nome;
    private HashMap<Studente, List<Integer>> voti;

    public Materia(String nome) {
        this.nome = nome;
        this.voti = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Integer> getVoti(Studente s){
        return voti.get(s);
    }

    public HashMap<Studente, List<Integer>> getVoti() {
        return voti;
    }

    public void setVoti(HashMap<Studente, List<Integer>> voti) {
        this.voti = voti;
    }

    public void aggiungiVoto(Studente s, int voto){
        voti.computeIfAbsent(s, k -> new ArrayList<>()).add(voto);
    }

    public void aggiungiVoti(Studente s, List<Integer> v){
        voti.computeIfAbsent(s, k -> new ArrayList<>()).addAll(v);
    }

    public void rimuoviVoto(Studente s, int voto){
        voti.get(s).remove(voto);
    }

    public void modificaVoto(Studente s, int votoVecchio, int votoNuovo){
        int indice = voti.get(s).indexOf(votoVecchio);
        voti.get(s).set(indice, votoNuovo);
    }

    public double mediaVoti(Studente s){
        return voti.get(s).stream().mapToInt(Integer::intValue).average().getAsDouble();
    }
}
