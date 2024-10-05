package poo23;

import java.util.HashMap;

public class Voto {
    HashMap<String, Integer> voti;
    int numVoti;

    public Voto() {
        voti = new HashMap<>();
        numVoti = 0;
    }

    public void aggiungiVoto(String materia, int voto) {
        voti.put(materia, voto);
        numVoti++;
    }

    public int getVoto(String nome) {
        return voti.get(nome);
    }
    public int getNumVoti() {
        return numVoti;
    }

    public String toString() {
        String s = "";
        for (String nome : voti.keySet()) {
            s += nome + ": " + voti.get(nome) + "\t\t";
        }
        return s;
    }
}
