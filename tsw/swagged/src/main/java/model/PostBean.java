package model;

import java.io.Serializable;

public class PostBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String titolo;
    private String corpo;
    private String immagine;
    private int segnalazioni;
    private int likes;
    private String utenteEmail;
    private int communityId;

    public PostBean() {
        this.id = -1;
        this.titolo = "";
        this.corpo = "";
        this.immagine = "";
        this.segnalazioni = 0;
        this.likes = 0;
        this.utenteEmail = "";
        this.communityId = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
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

	public String getUtenteEmail() {
        return utenteEmail;
    }

    public void setUtenteEmail(String utenteEmail) {
        this.utenteEmail = utenteEmail;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
