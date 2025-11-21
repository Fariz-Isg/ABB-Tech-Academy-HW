package HW12.Iterator;

import java.util.Iterator;

public class Main {
    static void main() {
        Playlist playlist = new Playlist("Road Trip Mix");
        playlist.addSong(new Song("Bohemian Rhapsody", "Queen"));
        playlist.addSong(new Song("Hotel California", "Eagles"));
        playlist.addSong(new Song("Sweet Child O' Mine", "Guns N' Roses"));
        playlist.addSong(new Song("Stairway to Heaven", "Led Zeppelin"));

        System.out.println("\nPlaying in order:");
        Iterator<Song> sequential = playlist.sequentialIterator();
        int count = 1;
        while (sequential.hasNext()) {
            System.out.println("  " + count++ + ". " + sequential.next());
        }

        System.out.println("\nPlaying shuffled:");
        Iterator<Song> shuffled = playlist.shuffleIterator();
        count = 1;
        while (shuffled.hasNext()) {
            System.out.println("  " + count++ + ". " + shuffled.next());
        }

        System.out.println("\nPlaying in reverse:");
        Iterator<Song> reversed = playlist.reverseIterator();
        count = 1;
        while (reversed.hasNext()) {
            System.out.println("  " + count++ + ". " + reversed.next());
        }
    }
}
