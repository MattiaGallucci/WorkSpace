package model;

import java.io.Serializable;

public class SegnalaCommunityBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String utenteEmail;
    private int communityId;

    public SegnalaCommunityBean() {
        this.utenteEmail = "";
        this.communityId = -1;
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
