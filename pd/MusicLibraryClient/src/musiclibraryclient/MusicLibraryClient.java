/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package musiclibraryclient;

import it.pd2024.musiclibrary.MusicLibrary;
import it.pd2024.musiclibrary.MusicLibraryRemote;
import it.pd2024.musiclibrary.Playlist;
import it.pd2024.musiclibrary.Song;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author matti
 */
public class MusicLibraryClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NamingException {
        
        Context ctx = new InitialContext();
        MusicLibraryRemote ejb = (MusicLibraryRemote) ctx.lookup("java:global/MusicLibrary/MusicLibrary!it.pd2024.musiclibrary.MusicLibraryRemote");
        
        System.out.println("trova canzoni:");
        List<Song> listaCanzoni = ejb.findSongs();
        for(Song s: listaCanzoni)
            System.out.println(s);
        
        System.out.println("play canzone:");
        URL url = ejb.play(1);
        System.out.println(url);
        
        System.out.println("verifica aumento views:");
        List<Song> lista = ejb.findSongs();
        for(Song s: lista)
            System.out.println(s);
        
        System.out.println("trova playlist:");
        List<Playlist> listaPlaylist = ejb.trovaPlaylist();
        for(Playlist pl: listaPlaylist)
            System.out.println(pl);
        
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci l'id della playlist che vuoi modificare:");
        long id = sc.nextLong();
        sc.nextLine();
        System.out.println("Inserisci nome:");
        String nome = sc.nextLine();
        System.out.println("Inserisci autore:");
        String autore = sc.nextLine();
        System.out.println("Inserisci tipologia:");
        String tipologia = sc.nextLine();
        System.out.println("Inserisci descrizione:");
        String descrizione = sc.nextLine();
        ejb.modificaPlaylist(id, nome, autore, tipologia, descrizione);
        List<Playlist> listaPlaylist1 = ejb.trovaPlaylist();
        for(Playlist pl: listaPlaylist1)
            System.out.println(pl);
        
        System.out.println("Inserisci l'id della playlist che vuoi eliminare:");
        id = sc.nextLong();
        sc.nextLine();*/
        ejb.eliminaPlaylist(3);
        System.out.println("Visualizza playlist dopo eliminazione:");
        List<Playlist> listaPlaylist2 = ejb.trovaPlaylist();
        for(Playlist pl: listaPlaylist2)
            System.out.println(pl);
        System.out.println("Visualizza canzoni dopo eliminazione:");
        List<Song> listaCanzoni2 = ejb.findSongs();
        for(Song s: listaCanzoni2)
            System.out.println(s);
    }
}
