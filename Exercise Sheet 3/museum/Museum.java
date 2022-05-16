package com.company.museum;

import java.util.HashSet;

public class Museum {
    private String name;
    private HashSet<Artwork> artworks = new HashSet<>(); //ArrayList would be fine as well

    public Museum(String name) {
        this.name = name;
    }

    public Artwork getArtworkByName(String name) {
        for (Artwork a : artworks) {
            if (a.getName().equals(name)) {
                return a; //found
            }
        }
        return null; //none found
    }

    public void addArtwork(String name, String artist, int value) {
        artworks.add(new Artwork(name, artist, value));
    }

    public HashSet<Artwork> getArtworks() {
        return artworks;
    }

    public String getName() {
        return name;
    }
}