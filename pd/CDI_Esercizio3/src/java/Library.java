
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matti
 */
public class Library {

    @Inject
    private ArrayList<Song> db;

    // Aggiunge una canzone alla libreria
    public void addSong(Song song) {
        db.add(song);
    }

    // Rimuove una canzone dalla libreria tramite ID
    public boolean deleteSongById(int id) {
        return db.removeIf(song -> song.getId() == id);
    }

    // Trova una canzone per ID
    public Optional<Song> findSongById(int id) {
        return db.stream().filter(song -> song.getId() == id).findFirst();
    }

    // Trova una canzone per nome
    public List<Song> findSongsByTitolo(String name) {
        List<Song> result = new ArrayList<>();
        db.stream().filter(song -> song.getTitolo().equalsIgnoreCase(name)).forEach(result::add);
        return result;
    }

    // Restituisce tutte le canzoni
    public List<Song> getAllSongs() {
        return db;
    }
}
