package HW12.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SequentialIterator implements Iterator<Song> {
    private List<Song> songs;
    private int index;

    public SequentialIterator(List<Song> songs) {
        this.songs = songs;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < songs.size();
    }

    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return songs.get(index++);
    }
}
