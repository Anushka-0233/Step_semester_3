import java.util.Arrays;

public class Playlist {

    private String[] songs;
    private int count;

    Playlist(int maxSongs) {
        songs = new String[maxSongs];
        count = 0;
    }

    void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }

    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs:");
        for (int i = 0; i < copy.length; i++) {
            System.out.println(copy[i]);
        }

        // Changing the copy
        copy[0] = "Hacked";

        System.out.println("\nOriginal playlist:");
        String[] original = p.getSongs();

        for (int i = 0; i < original.length; i++) {
            System.out.println(original[i]);
        }

        System.out.println("\nSong count: " + p.getSongCount());
    }
}