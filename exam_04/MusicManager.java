import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

public class MusicManager {

    private Set<Song> allSongs;


    public MusicManager() {
        this.allSongs = new HashSet<>();
    }


    public void addSong(Song s) {
        if (this.allSongs.contains(s)) {
            System.out.println("The song is already in the set!");
        }
        else {
            this.allSongs.add(s);
        }
    }


    public List<Song> makePlayList(String a) {
        return this.allSongs.stream()
            .filter(s -> s.getArtist().equals(a))
            .collect(Collectors.toList());
    }


    public boolean remove(int y) {
        int originalSize = this.allSongs.size();
         this.allSongs = this.allSongs.stream()
            .filter(s -> s.getYear() != y)
            .collect(Collectors.toSet());
            
        return this.allSongs.size() < originalSize;
    } 
    

    public Map<String, Integer> artistSongs() {
        return this.allSongs.stream()
            .collect(Collectors.toMap(s -> s.getArtist(), s -> 1, Integer::sum));
    }


    public void playWithAds(List<Song> l) {
        int counter = 0;
        for (Song song : l) {
            song.play();
            counter++;
            if (counter % 5 == 0) {
                System.out.println("playing advertisements");
            }
        }
    }


    public Song findMostPopular(List<Song> l) {
        return l.stream()
            .sorted(Comparator.comparingInt(Song::getLikes).reversed())
            .findFirst()
            .orElse(null);
    }


    public void playTopHits(List<Song> l) {
        Comparator<Song> comp = (l.size() < 20) ?
            Comparator.comparingInt(s -> 0) : 
            Comparator.comparingInt(Song::getLikes).reversed();

        l.stream()
            .sorted(comp)
            .limit(20)
            .collect(Collectors.toList())
            .forEach(s -> { s.like(); s.play(); l.remove(s); });
        
    }


    public static void main(String[] args) {
        Song song1 = new Song("Trains", "Porcupine Tree", 2002);
        Song song2 = new Song("Bleak", "Opeth", 2001);
        MusicManager manager = new MusicManager();
        manager.addSong(song1);
        manager.addSong(song2);
    }
}
