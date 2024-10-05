package poo23;

import java.util.Scanner;

public class Studente extends Persona{
    private int matricola;
    private int annoIscrizione;
    private boolean isLavoratore;
    private int voto;

    public Studente(String nome, String cognome, int matricola, int annoIscrizione, boolean isLavoratore, int voto){
        super(nome, cognome);
        this.matricola = matricola;
        this.annoIscrizione = annoIscrizione;
        this.isLavoratore = isLavoratore;
        this.voto = voto;
    }

    public void setMatricola(int matricola) { this.matricola = matricola; }
    public int getMatricola() { return matricola; }
    public void setAnnoIscrizione(int annoIscrizione) { this.annoIscrizione = annoIscrizione; }
    public int getAnnoIscrizione() { return annoIscrizione; }
    public void setLavoratore(boolean isLavoratore) { this.isLavoratore = isLavoratore; }
    public boolean isLavoratore() { return isLavoratore; }
    public void setVoto(int voto) { this.voto = voto; }
    public int getVoto() { return voto; }

    public String toString(){
        return super.toString() + "\tMatricola: " + getMatricola() + "\tAnno Iscrizione: " + getAnnoIscrizione() + "\tLavoratore: " + isLavoratore() + "\tVoto: " + getVoto();
    }

    public Studente aggiungiStudente(Studente s){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nome: ");
        s.setNome(sc.nextLine());

        System.out.print("Cognome: ");
        s.setCognome(sc.nextLine());

        System.out.print("Matricola: ");
        s.setMatricola(sc.nextInt());

        System.out.print("Anno Iscrizione: ");
        s.setAnnoIscrizione(sc.nextInt());

        System.out.print("Lavoratore? (S/N): ");
        s.setLavoratore(sc.next().equals("S"));

        System.out.print("Voto: ");
        s.setVoto(sc.nextInt());

        // sc.close();
        return s;
    }

}
