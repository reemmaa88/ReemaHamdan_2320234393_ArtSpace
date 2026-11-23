package com.example.mid_exam_reema_hamdan;

public class Artwork {
    private int imageResId;
    private String title;
    private String artist;
    private String year;

    public Artwork(int imageResId, String title, String artist, String year) {
        this.imageResId = imageResId;
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getYear() {
        return year;
    }
}
