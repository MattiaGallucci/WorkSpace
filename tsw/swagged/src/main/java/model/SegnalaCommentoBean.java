package model;

import java.io.Serializable;

public class SegnalaCommentoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String utenteEmail;
    private int commentoId;

    public SegnalaCommentoBean() {
        this.utenteEmail = "";
        this.commentoId = -1;
    }

    public String getUtenteEmail() {
        return utenteEmail;
    }

    public void setUtenteEmail(String utenteEmail) {
        this.utenteEmail = utenteEmail;
    }

    public int getCommentoId() {
        return commentoId;
    }

    public void setCommentoId(int commentoId) {
        this.commentoId = commentoId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
