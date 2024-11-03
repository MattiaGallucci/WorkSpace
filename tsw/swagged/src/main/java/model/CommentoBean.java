package model;

import java.io.Serializable;

public class CommentoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String corpo;
    private int segnalazioni;
    private int likes;
    private int padre;
    private String utenteEmail;
    private int postId;

    public CommentoBean() {
        this.id = -1;
        this.corpo = "";
        this.segnalazioni = 0;
        this.likes = 0;
        this.padre = 0;
        this.utenteEmail = "";
        this.postId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    public void aggiungiLike() {
    	this.likes++;
    }
    
    public void rimuoviLike() {
    	this.likes--;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public String getUtenteEmail() {
        return utenteEmail;
    }

    public void setUtenteEmail(String utenteEmail) {
        this.utenteEmail = utenteEmail;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
