package poo23;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

public class Main 
{
    public static void main( String[] args )
    {
        //List<Album> favs = new ArrayList<>();
        List<Album> albums = new ArrayList<>();
        //List<Track> tracks = new ArrayList<>();
        
        /*
            ********************************************************
            **  for (Album a : albums) {                          **  
            **      boolean hasFavorite = false;                  **  
            **      for (Track t : a.tracks) {                    **  
            **          if (t.rating >= 4) {                      **  
            **              hasFavorite = true;                   **  
            **              break;                                **  
            **          }                                         **  
            **      }                                             **  
            **      if (hasFavorite)                              **  
            **          favs.add(a);                              **  
            **  }                                                 **  
            **  Collections.sort(favs, new Comparator<Album>() {  **  
            **      public int compare(Album a1, Album a2) {      **  
            **          return a1.name.compareTo(a2.name);        **  
            **      }                                             **  
            **  });                                               **  
            ********************************************************
                                        |
                                        |
                                        |
                                        V
        */

        List<Album> favAlbum = albums.stream().filter(a->a.tracks.stream().anyMatch(t->t.rating>=4)).toList();
        favAlbum.sort((a1, a2) -> a1.name.compareTo(a2.name));
    }
}
