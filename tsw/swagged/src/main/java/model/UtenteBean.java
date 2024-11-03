package model;

import java.io.Serializable;

public class UtenteBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String email;
    private String username;
    private String password;
    private String immagine;
    private int segnalazioni;
    private boolean bandito;
    private int follower;
    private int seguiti;
    private boolean admin;

    public UtenteBean() {
        this.email = "";
        this.username = "";
        this.password = "";
        this.immagine = "";
        this.segnalazioni = 0;
        this.bandito = false;
        this.follower = 0;
        this.seguiti = 0;
        this.admin = false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isBandito() {
        return bandito;
    }

    public void setBandito(boolean bandito) {
        this.bandito = bandito;
    }
    
    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }
    
    public void aumentaFollower() {
    	this.follower++;
    }
    
    public void diminuisciFollower() {
    	if (this.follower > 0) { // Assicurati di non andare sotto zero
            this.follower--;
        }
    }

    public int getSeguiti() {
        return seguiti;
    }

    public void setSeguiti(int seguiti) {
        this.seguiti = seguiti;
    }
    
    public void aumentaSeguiti() {
    	this.seguiti++;
    }
    
    public void diminuisciSeguiti() {
    	if (this.seguiti > 0) { // Assicurati di non andare sotto zero
            this.seguiti--;
        }
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
