public class Song {

    private String title;
    private String artist;
    private int likes;
    private int year;


    public Song(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.likes = 0;
    }


    public String getTitle() {
        return this.title;
    }


    public String getArtist() {
        return this.artist;
    }


    public int getYear() {
        return this.year;
    }


    public int getLikes() {
        return this.likes;
    }


    public void like() {
        this.likes++;
    }


    public boolean compare(Song anotherSong) {
        return this.getLikes() > anotherSong.getLikes();
    }


    public void play() {
        System.out.println("The song Title: " + this.title +
                            ", Artist: " + this.artist +
                            ", Year: " +  this.year + " is playing!");
    }
}
