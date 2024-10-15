package model;

import java.io.Serializable;

public class SegnalaPostBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String utenteEmail;
    private int postId;

    public SegnalaPostBean() {
        this.utenteEmail = "";
        this.postId = -1;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
