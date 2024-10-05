package oop23;

public class Persona 
{
    protected int eta;
    protected String nome;
    protected String sesso;
    
    public Persona(String nome, String sesso, int eta) {
        this.nome=new String(nome);
        this.sesso=new String(sesso);
        this.eta=eta;
    }
    
    public void ChiSei() {
        System.out.println("Sono una persona di nome "+nome+", sesso: "+sesso+", età: "+eta);
    }
}

class Studente extends Persona{
    protected int esami;
    protected int matricola;
    protected String facolta;
    
    public Studente(String nome, String sesso, int eta, int esami, int matricola, String facolta) {
        super(nome, sesso,eta); //chiamata esplicita al costrutt. della classe base
        this.esami=esami;
        this.matricola=matricola;
        this.facolta=new String(facolta);
    }
    
    public void ChiSei() {
        super.ChiSei();
        System.out.println("In particolare sono uno studente iscritto alla facolta di "+facolta+", matricola: "+matricola+", esami: "+esami);
    }
}