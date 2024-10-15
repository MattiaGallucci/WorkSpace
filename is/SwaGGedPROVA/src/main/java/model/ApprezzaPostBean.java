package model;

import java.io.Serializable;

public class ApprezzaPostBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String utenteEmail;
    private int postId;
    private int apprezzamento;

    public ApprezzaPostBean() {
        this.utenteEmail = "";
        this.postId = -1;
        this.apprezzamento = 0; // Default value as specified in the table
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

    public int getApprezzamento() {
        return apprezzamento;
    }

    public void setApprezzamento(int apprezzamento) {
        this.apprezzamento = apprezzamento;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
