package HW12.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class ReverseIterator implements Iterator<Song> {
    private List<Song> songs;
    private int index;

    public ReverseIterator(List<Song> songs) {
        this.songs = songs;
        this.index = songs.size() - 1;
    }

    public boolean hasNext() {
        return index >= 0;
    }

    public Song next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return songs.get(index--);
    }
}