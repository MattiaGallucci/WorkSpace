/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.pd2024.musiclibrary;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author matti
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource", name = "java:global/jdbc/MusicLibraryDataSource",
        user = "APP",
        password = "APP",
        databaseName = "MusicLibraryDB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

    private Song s1, s2;
    private Playlist pl1;
    @Inject
    private MusicLibrary lib;

    @PostConstruct
    private void populateDB() {
        try {
            s1 = new Song("Queen", "We Are The Champions", new URL("https://www.youtube.com/embed/KXw8CRapg7k"), 2003, 1234, "testo");
            s2 = new Song("Home Free", "Sea Shanty Medley", new URL("https://www.youtube.com/embed/lLGLUSzzuWU"), 2005, 5678, "testo");
            lib.createSong(s1);
            lib.createSong(s2);
            
            List<Song> canzoni = new ArrayList<>();
            canzoni.add(s1);
            canzoni.add(s2);
            pl1 = new Playlist("pl1", "mattia", "pop", "desc", canzoni);
            pl1.setCanzoni(canzoni);
            lib.creaPlaylist(pl1);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(DatabasePopulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
