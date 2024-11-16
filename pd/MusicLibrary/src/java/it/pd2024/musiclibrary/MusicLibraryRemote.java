/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.pd2024.musiclibrary;

import java.net.URL;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author matti
 */
@Remote
public interface MusicLibraryRemote {
    public Song createSong(Song song);
    public Song createSong(String authors, String name, URL url, int annoRilascio, int visualizzazioni, String lyrics);
    public List<Song> findSongs();
    public List<Song> cercaPerAnno(int anno);
    public List<Song> cercaPerAutore(String autore);
    public List<Song> cercaPerNome(String nome);
    
    public Playlist creaPlaylist(Playlist pl); //CREA
    public Playlist creaPlaylist(String nome, String autore, String tipologia, String descrizione, List<Song> canzoni); //CREA
    public List<Playlist> trovaPlaylist(); //VISUALIZZA
    public List<Playlist> cercaPerTipologia(String tipologia); //CERCA PER TIPOLOGIA
    public Playlist modificaPlaylist(Playlist pl); //MODIFICA
    public Playlist modificaPlaylist(long id, String nome, String autore, String tipologia, String descrizione/*, List<Song> canzoni*/); //MODIFICA
    public void eliminaPlaylist(Playlist pl); //ELIMINA
    public void eliminaPlaylist(long id); //ELIMINA
    
    public URL play(long id);
}
