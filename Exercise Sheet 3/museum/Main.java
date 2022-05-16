package com.company.museum;

public class Main {
    public static void main(String[] args) {
        Museum m = new Museum("Senckenbergmuseum");
        System.out.printf("The museum's name is %s.%n", m.getName());

        m.addArtwork("T-Rex", "John Appleseed", 20000);
        m.addArtwork("Triceratops", "Monet", 30000);
        m.addArtwork("Velociraptor", "Monet", 40000);

        //not a task:
        //proof that the return value is by reference
        m.getArtworkByName("T-Rex").setValue(2);
        System.out.printf("New value: %,d.%n", m.getArtworkByName("T-Rex").getValue());

        //calculate the total value of all pieces of art of the artist "Monet"
        String artistName = "Monet";
        int totalValue = 0;
        for (Artwork a : m.getArtworks()) {
            if (a.getArtist().equals(artistName)) {
                totalValue += a.getValue();
            }
        }
        System.out.printf("The total value of all artworks of the artist %s is %,d €.%n", artistName, totalValue);
    }
}