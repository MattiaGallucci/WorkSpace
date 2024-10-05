package poo23;

import java.util.ArrayList;
import java.util.List;

public class Studente {
    private String nome;
    private String cognome;
    private int matricola;
    private List<Voto> voti;

    public Studente(String nome,String cognome, int matricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        voti = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public List<Voto> getVoti() {
        return voti;
    }

    public void setVoti(List<Voto> voti) {
        this.voti = voti;
    }
    
    public void aggiungiVoto(Voto ... voto){
        for(Voto v : voto)
            voti.add(v);
    }

    public double getMedia(){
        double somma = 0;
        for(Voto v : voti)
            somma += v.getVoto();
        return somma/voti.size();
    }

    @Override
    public String toString() {
        return "Studente [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", voti=" + voti + "]\n\t\t";
    }

    

    
}
