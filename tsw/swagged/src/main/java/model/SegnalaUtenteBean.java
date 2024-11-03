package model;

import java.io.Serializable;

public class SegnalaUtenteBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String segnalatoreEmail;
    private String segnalatoEmail;

    public SegnalaUtenteBean() {
        this.segnalatoreEmail = "";
        this.segnalatoEmail = "";
    }

    public String getSegnalatoreEmail() {
        return segnalatoreEmail;
    }

    public void setSegnalatoreEmail(String segnalatoreEmail) {
        this.segnalatoreEmail = segnalatoreEmail;
    }

    public String getSegnalatoEmail() {
        return segnalatoEmail;
    }

    public void setSegnalatoEmail(String segnalatoEmail) {
        this.segnalatoEmail = segnalatoEmail;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
