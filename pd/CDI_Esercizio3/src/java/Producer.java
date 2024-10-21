
import java.util.ArrayList;
import javax.enterprise.inject.Produces;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author matti
 */
public class Producer {
     @Produces
    public ArrayList<Song> produceSongList() {
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Bohemian Rhapsody", 100, 1));
        songs.add(new Song("Imagine", 200, 2));
        songs.add(new Song("Hotel California", 300, 3));
        songs.add(new Song("Billie Jean", 400, 4));
        return songs;
    }
}
