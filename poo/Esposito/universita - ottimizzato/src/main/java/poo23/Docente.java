package poo23;

import java.util.Scanner;

public class Docente extends Persona{
    private String afferenza;
    private boolean isDocente;
    
    public Docente(String nome, String cognome, String afferenza, boolean isDocente) {
        super(nome, cognome);
        this.afferenza = afferenza;
        this.isDocente = isDocente;
    }

    public void setAfferenza(String afferenza) { this.afferenza = afferenza; }
    public String getAfferenza() { return afferenza;}
    public void setDocente(boolean isDocente) { this.isDocente = isDocente; }
    public boolean isDocente() { return isDocente; }

    public String toString() {
        return super.toString() + "\tDocente di: " + afferenza + "\tDocente: " + isDocente;
    }

    public Docente aggiungiDocente(Docente d, String s){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nome: ");
        d.setNome(sc.nextLine());

        System.out.print("Cognome: ");
        d.setCognome(sc.nextLine());

        d.setAfferenza(s);

        System.out.print("Docente? (S/N) ");
        d.setDocente(sc.next().equals("S"));

        // sc.close();
        return d;
    }
}
