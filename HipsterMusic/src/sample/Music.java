package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Music {

    //StringProperty is needed for TableView
    private StringProperty album;
    private StringProperty artist;
    private StringProperty genre;
    private StringProperty year;

    //Default fallback constructor
    public Music() {
        this("","","","");
    }

    public Music(String album, String artist, String genre, String year) {
        this.album = new SimpleStringProperty(album);
        this.artist = new SimpleStringProperty(artist);
        this.genre = new SimpleStringProperty(genre);
        this.year = new SimpleStringProperty(year);
    }


    public String getAlbum() {
        return album.get();
    }

    public StringProperty albumProperty() {
        return album;
    }

    public void setAlbum(String album) {
        this.album.set(album);
    }

    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist.set(artist);
    }

    public String getGenre() {
        return genre.get();
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public String getYear() {
        return year.get();
    }

    public StringProperty yearProperty() {
        return year;
    }

    public void setYear(String year) {
        this.year.set(year);
    }

    @Override
    public String toString() {
        return "Music{" +
                "album=" + album +
                ", artist=" + artist +

                ", genre=" + genre +
                ", year=" + year +
                '}';
    }

}
