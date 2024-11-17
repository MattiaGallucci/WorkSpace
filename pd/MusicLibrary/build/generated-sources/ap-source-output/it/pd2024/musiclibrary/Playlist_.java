package it.pd2024.musiclibrary;

import it.pd2024.musiclibrary.Song;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-11-17T15:22:36")
@StaticMetamodel(Playlist.class)
public class Playlist_ { 

    public static volatile SingularAttribute<Playlist, String> descrizione;
    public static volatile ListAttribute<Playlist, Song> canzoni;
    public static volatile SingularAttribute<Playlist, String> nome;
    public static volatile SingularAttribute<Playlist, Long> ID;
    public static volatile SingularAttribute<Playlist, String> autore;
    public static volatile SingularAttribute<Playlist, String> tipologia;

}