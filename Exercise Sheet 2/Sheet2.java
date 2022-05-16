package com.company;

import java.io.*;

public class Sheet2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Display[] displays = {
                new Publication("My book's title", "German", 1299),
                new Book("My Book's Title", "German", 2999, "John Appleseed", "978-978948456"),
                new Car("black", 100, 1800)
        };

        printAll(displays);

        //exercise 6
        String fileName = "displays.ser";

        System.out.println("Serializing");
        serializeDisplaysToFile(displays, new FileOutputStream(fileName));

        System.out.println("Deserializing\n");
        displays = deserializeDisplaysFromFile(new FileInputStream(fileName));

        printAll(displays);
    }

    public static void serializeDisplaysToFile(Display[] displays, FileOutputStream fs) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(displays);
    }

    public static Display[] deserializeDisplaysFromFile(FileInputStream fs) throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(fs);
        Display[] displays = (Display[])is.readObject();
        return displays;
    }

    //exercise 5
    static void printAll(Display[] displays) {
        for (Display display : displays) {
            display.print();
            System.out.println("");
        }
    }
}
