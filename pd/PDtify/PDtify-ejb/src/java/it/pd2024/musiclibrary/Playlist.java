/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.pd2024.musiclibrary;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author matti
 */

import static it.pd2024.musiclibrary.Playlist.TROVA_TUTTE;
import static it.pd2024.musiclibrary.Playlist.CERCA_PER_TIPOLOGIA;
import static it.pd2024.musiclibrary.Playlist.MODIFICA;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import static it.pd2024.musiclibrary.Playlist.ELIMINA;
import javax.persistence.FetchType;

import javax.persistence.TemporalType;
@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTE, query = "SELECT p FROM Playlist p"),
    @NamedQuery(name = CERCA_PER_TIPOLOGIA, query = "SELECT p FROM Playlist p WHERE p.tipologia = :tipologia"),
    @NamedQuery(name = MODIFICA, query = "UPDATE Playlist p SET p.nome = :nome, p.autore = :autore, p.tipologia = :tipologia, p.descrizione = :descrizione WHERE p.ID = :id"),
    @NamedQuery(name = ELIMINA, query = "DELETE FROM Playlist p WHERE p.ID = :id"),
})
public class Playlist implements Serializable{
    public static final String TROVA_TUTTE = "Playlist.trovaTuttePlaylist";
    public static final String CERCA_PER_TIPOLOGIA = "Playlist.cercaPerTipologia";
    public static final String MODIFICA = "Playlist.modifica";
    public static final String ELIMINA = "Playlist.elimina";
    
    @Id @GeneratedValue
    private long ID;
    private String nome;
    private String autore;
    private String tipologia;
    private String descrizione;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Song> canzoni;
    
    public Playlist(){}

    public Playlist(String nome, String autore, String tipologia, String descrizione, List<Song> canzoni) {
        this.nome = nome;
        this.autore = autore;
        this.tipologia = tipologia;
        this.descrizione = descrizione;
        this.canzoni = canzoni;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    

    public List<Song> getCanzoni() {
        return canzoni;
    }

    public void setCanzoni(List<Song> canzoni) {
        this.canzoni = canzoni;
    }

    @Override
    public String toString() {
        return "Playlist{" + "ID=" + ID + ", nome=" + nome + ", autore=" + autore + ", tipologia=" + tipologia + ", descrizione=" + descrizione + ", canzoni=" + canzoni + '}';
    }

    
}
