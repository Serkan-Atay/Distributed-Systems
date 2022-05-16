package com.company.museum;

public class Artwork {
    private String name;
    private String artist;
    private int value; //in euro

    public Artwork(String name, String artist, int value) {
        this.name = name;
        this.artist = artist;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}