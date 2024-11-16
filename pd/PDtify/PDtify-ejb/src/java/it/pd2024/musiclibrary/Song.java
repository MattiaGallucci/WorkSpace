/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.pd2024.musiclibrary;

import java.io.Serializable;
import java.net.URL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import static it.pd2024.musiclibrary.Song.TROVA_TUTTE;
import static it.pd2024.musiclibrary.Song.CERCA_PER_ANNO;
import static it.pd2024.musiclibrary.Song.CERCA_PER_AUTORE;
import static it.pd2024.musiclibrary.Song.CERCA_PER_NOME;
import static it.pd2024.musiclibrary.Song.CERCA_PER_ID;
@Entity
@NamedQueries({
    @NamedQuery(name = TROVA_TUTTE, query = "SELECT s FROM Song s"),
    @NamedQuery(name = CERCA_PER_ANNO, query = "SELECT s FROM Song s WHERE s.annoRilascio = :anno"),
    @NamedQuery(name = CERCA_PER_AUTORE, query = "SELECT s FROM Song s WHERE s.authors = :autore"),
    @NamedQuery(name = CERCA_PER_NOME, query = "SELECT s FROM Song s WHERE s.name = :nome"),
    @NamedQuery(name = CERCA_PER_ID, query = "SELECT s FROM Song s WHERE s.ID = :id"),
})
public class Song implements Serializable{
    public static final String TROVA_TUTTE = "Song.trovaTutteCanzoni";
    public static final String CERCA_PER_ANNO = "Song.cercaPerAnno";
    public static final String CERCA_PER_AUTORE = "Song.cercaPerAutore";
    public static final String CERCA_PER_NOME = "Song.cercaPerNome";
    public static final String CERCA_PER_ID = "Song.cercaPerID";
    @Id @GeneratedValue
    private Long ID;
    private String authors;
    private String name;
    private URL url;
    private int annoRilascio;
    private int visualizzazioni;
    private String lyrics;
    
    public Song() {}
    
    public Song(String authors, String name, URL url, int annoRilascio, int visualizzazioni, String lyrics) {
        this.authors = authors;
        this.name = name;
        this.url = url;
        this.annoRilascio = annoRilascio;
        this.visualizzazioni = visualizzazioni;
        this.lyrics = lyrics;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public int getAnnoRilascio() {
        return annoRilascio;
    }

    public void setAnnoRilascio(int annoRilascio) {
        this.annoRilascio = annoRilascio;
    }

    public int getVisualizzazioni() {
        return visualizzazioni;
    }

    public void setVisualizzazioni(int visualizzazioni) {
        this.visualizzazioni = visualizzazioni;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public String toString() {
        return "Song{" + "ID=" + ID + ", authors=" + authors + ", name=" + name + ", url=" + url + ", annoRilascio=" + annoRilascio + ", visualizzazioni=" + visualizzazioni + ", lyrics=" + lyrics + '}';
    }
}
