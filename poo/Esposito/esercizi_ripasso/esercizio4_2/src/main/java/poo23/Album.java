package poo23;

import java.util.ArrayList;
import java.util.List;

public class Album {
    public List<Track> tracks;
    public String name;

    public Album() {
        tracks = new ArrayList<>();
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    
}
