import java.util.ArrayList;

public class Java_Exercise_2 {
    public static class Publication {
        private String title;
        private String language;
        private int price;

        public void setTitle(String title) {
            this.title = title;
        }
        public void setLanguage(String language) {
            this.language = language;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        public String getTitle() {
            return this.title;
        }
        public String getLanguage() {
            return this.language;
        }
        public int getPrice() {
            return this.price;
        }
        public Publication() {

        }
        public Publication(String title, String language, int price) {
            this.title = title;
            this.language = language;
            this.price = price;
        }

        public void print() {
            System.out.println("Title is " + title + ".");
            System.out.println("Language is " + language + ".");
            System.out.println("Price is " + price + ".");
        }
    }
    public static class Book extends Publication {
        private String Author;
        private String ISBN;

        public Book(String Author, String ISBN, String title, String language, int price) {
                this.Author = Author;
                this.ISBN = ISBN;
                setTitle(title);
                setLanguage(language);
                setPrice(price);
            }
            public void print() {
                System.out.println("Author is " + Author + ".");
                System.out.println("ISBN is " + ISBN + ".");
                System.out.println("Title is " + getTitle() + ".");
                System.out.println("Language is " + getLanguage() + ".");
                System.out.println("Price is " + getPrice() + ".");
            }

        }
    public static void main(String[] args) {
        Publication[] p2 = new Publication[5];
        // Over 90 % done. Merely needs an array iteration...

        for(Publication i : p2) {
            System.out.println(i);
        }
    }
}