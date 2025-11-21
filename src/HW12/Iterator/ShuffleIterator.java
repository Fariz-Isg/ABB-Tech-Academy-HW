package HW12.Iterator;

import java.util.*;

class ShuffleIterator implements Iterator<Song> {
    private List<Song> songs;
    private int index;

    public ShuffleIterator(List<Song> songs) {
        this.songs = new ArrayList<>(songs);
        Collections.shuffle(this.songs);
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