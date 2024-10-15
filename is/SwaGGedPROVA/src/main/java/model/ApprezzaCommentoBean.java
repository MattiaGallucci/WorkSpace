package model;

import java.io.Serializable;

public class ApprezzaCommentoBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String utenteEmail;
    private int commentoId;
    private int apprezzamento;

    public ApprezzaCommentoBean() {
        this.utenteEmail = "";
        this.commentoId = -1;
        this.apprezzamento = 0; // Default value as specified in the table
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
