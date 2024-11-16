/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.pd2024.musiclibrary;

import java.net.URL;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author matti
 */
@Stateless
@LocalBean
public class MusicLibrary implements MusicLibraryRemote{
    
    @Inject
    private EntityManager em;

    public Song createSong(Song song) {
        em.persist(song);
        return song;
    }
    public Song createSong(String authors, String name, URL url, int annoRilascio, int visualizzazioni, String lyrics){
        Song song = new Song(authors, name, url, annoRilascio, visualizzazioni, lyrics);
        em.persist(song);
        return song;
    }
    
    public List<Song> findSongs() {
        em.flush();
        TypedQuery<Song> query = em.createNamedQuery(Song.TROVA_TUTTE, Song.class);
        return query.getResultList();
    }
    
    public List<Song> cercaPerAnno(int anno){
        TypedQuery<Song> query = em.createNamedQuery(Song.CERCA_PER_ANNO, Song.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }
    
    public List<Song> cercaPerAutore(String autore){
        TypedQuery<Song> query = em.createNamedQuery(Song.CERCA_PER_AUTORE, Song.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }
    
    public List<Song> cercaPerNome(String nome){
        TypedQuery<Song> query = em.createNamedQuery(Song.CERCA_PER_NOME, Song.class);
        query.setParameter("nome", nome);
        return query.getResultList();
    }
    
    public Playlist creaPlaylist(Playlist pl){
        em.persist(pl);
        /*for(Song s: pl.getCanzoni())
            em.persist(s);*/
        return pl;
    }
    public Playlist creaPlaylist(String nome, String autore, String tipologia, String descrizione, List<Song> canzoni){
        Playlist pl = new Playlist(nome, autore, tipologia, descrizione, canzoni);
        em.persist(pl);
        return pl;
    }
    
    public List<Playlist> trovaPlaylist(){
        em.flush();
        TypedQuery<Playlist> query = em.createNamedQuery(Playlist.TROVA_TUTTE, Playlist.class);
        return query.getResultList();
    }
    
    public List<Playlist> cercaPerTipologia(String tipologia){
        TypedQuery<Playlist> query = em.createNamedQuery(Playlist.CERCA_PER_TIPOLOGIA, Playlist.class);
        query.setParameter("tipologia", tipologia);
        return query.getResultList();
    }
    
    @Interceptors(VisualizzazioniInterceptor.class)
    public URL play(long id){
        TypedQuery<Song> query = em.createNamedQuery(Song.CERCA_PER_ID, Song.class);
        query.setParameter("id", id);
        return query.getSingleResult().getUrl();
    }
    
    public Playlist modificaPlaylist(Playlist pl) {
        // Update basic fields
        Query query = em.createNamedQuery(Playlist.MODIFICA);
        query.setParameter("nome", pl.getNome());
        query.setParameter("autore", pl.getAutore());
        query.setParameter("tipologia", pl.getTipologia());
        query.setParameter("descrizione", pl.getDescrizione());  // Corrected "descrizioni" to "descrizione"
        query.setParameter("id", pl.getID());
        query.executeUpdate();

        // Retrieve and update the Playlist's canzoni collection
        Playlist playlist = em.find(Playlist.class, pl.getID());
        if (playlist != null) {
            playlist.setCanzoni(pl.getCanzoni());  // Update the collection
            em.merge(playlist);  // Persist changes
        }
        return playlist;
    }
    public Playlist modificaPlaylist(long id, String nome, String autore, String tipologia, String descrizione/*, List<Song> canzoni*/){
        Playlist playlist = em.find(Playlist.class, id);
        
        playlist.setNome(nome);
        playlist.setAutore(autore);
        playlist.setTipologia(tipologia);
        playlist.setDescrizione(descrizione);
        //playlist.setCanzoni(canzoni);
        
        em.merge(playlist);
        return playlist;
    }

    public void eliminaPlaylist(long id){
        em.remove(em.find(Playlist.class, id));
        /*Query query = em.createNamedQuery(Playlist.ELIMINA);
        query.setParameter("id", id);
        int result = query.executeUpdate();*/
    }
    
    public void eliminaPlaylist(Playlist pl){
        Query query = em.createNamedQuery(Playlist.ELIMINA);
        query.setParameter("id", pl.getID());
        query.executeUpdate();
    }

}
