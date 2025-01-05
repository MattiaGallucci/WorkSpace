package swagged.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommunityBean implements Serializable, Bean {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String descrizione;
    private int segnalazioni;
    private int iscritti;
    private String utenteEmail;

    private List<PostBean> post;

    public CommunityBean() {
        this.nome = "";
        this.descrizione = "";
        this.segnalazioni = 0;
        this.iscritti = 0;
        this.utenteEmail = "";
        post = new ArrayList<PostBean>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
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

    public int getIscritti() {
        return iscritti;
    }

    public void setIscritti(int iscritti) {
        this.iscritti = iscritti;
    }

    public void aggiungiIscritto() {
        this.iscritti++;
    }

    public void rimuoviIscritto() {
        this.iscritti--;
    }

    public String getUtenteEmail() {
        return utenteEmail;
    }

    public void setUtenteEmail(String email) {
        this.utenteEmail = email;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<PostBean> getPost() {
        return post;
    }

    public void setPost(List<PostBean> post) {
        this.post = post;
    }

    public boolean addPost(PostBean post){
        return this.post.add(post);
    }

    public boolean removePost(PostBean post){
        return this.post.remove(post);
    }

    @Override
    public String toString() {
        return "CommunityBean{" +
                "nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", segnalazioni=" + segnalazioni +
                ", iscritti=" + iscritti +
                ", utenteEmail='" + utenteEmail + '\'' +
                ", post=" + post +
                '}';
    }
}
