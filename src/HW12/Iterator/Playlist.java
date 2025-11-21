package HW12.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public Iterator<Song> sequentialIterator() {
        return new SequentialIterator(songs);
    }

    public Iterator<Song> shuffleIterator() {
        return new ShuffleIterator(songs);
    }

    public Iterator<Song> reverseIterator() {
        return new ReverseIterator(songs);
    }
}
