package model;

import java.io.Serializable;

public class SegueUtenteBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String seguaceEmail;
    private String seguitoEmail;

    public SegueUtenteBean() {
        this.seguaceEmail = "";
        this.seguitoEmail = "";
    }

    public String getSeguaceEmail() {
        return seguaceEmail;
    }

    public void setSeguaceEmail(String seguaceEmail) {
        this.seguaceEmail = seguaceEmail;
    }

    public String getSeguitoEmail() {
        return seguitoEmail;
    }

    public void setSeguitoEmail(String seguitoEmail) {
        this.seguitoEmail = seguitoEmail;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
