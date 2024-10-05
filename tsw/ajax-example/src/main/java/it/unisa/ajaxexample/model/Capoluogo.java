package it.unisa.ajaxexample.model;

public class Capoluogo {
    
    private String nome;
    private String CAP;
    private String regione;

    public Capoluogo(String nome, String CAP, String regione) {
        this.nome = nome;
        this.CAP = CAP;
        this.regione = regione;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    } 
    
}
