public class Java_Exercise_2 {
    public static class Publication {
        private String title;
        private String language;
        private int price;

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

            public Publication(String Author, String ISBN) {
                this.Author = Author;
                this.ISBN = ISBN;
            }
            public void print() {
                System.out.println("Title is " + title + ".");
                System.out.println("Language is " + language + ".");
                System.out.println("Price is " + price + ".");
            }

        }
    public static void main(String[] args) {
        Publication p = new Publication("Harry Potter", "English", 40000);

        p.print();
    }
}