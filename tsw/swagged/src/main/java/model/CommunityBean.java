package model;

import java.io.Serializable;

public class CommunityBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;
    private String descrizione;
    private int segnalazioni;
    private int iscritti;
    private String utenteEmail;

    public CommunityBean() {
        this.id = -1;
        this.nome = "";
        this.descrizione = "";
        this.segnalazioni = 0;
        this.iscritti = 0;
        this.utenteEmail = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getSegnalazioni() {
        return segnalazioni;
    }

    public void setSegnalazioni(int segnalazioni) {
        this.segnalazioni = segnalazioni;
    }
    
    public void aggiungiSegnalazione() {
    	this.segnalazioni++;
    }
    
    public int getIscritti() {
        return iscritti;
    }

    public void setIscritti(int iscritti) {
        this.iscritti = iscritti;
    }
    
    public void aggiungiIscritto() {
    	this.iscritti++;
    }
    
    public void rimuoviIscritto() {
    	this.iscritti--;
    }

    public String getUtenteEmail() {
        return utenteEmail;
    }

    public void setUtenteEmail(String email) {
        this.utenteEmail = email;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
