class Testing_and_Tutorial {
    public void start() {
        System.out.println("This is running inside of a thread.");
    }
    public static void main(String[] args) {
        Testing_and_Tutorial Thread = new Testing_and_Tutorial();
        System.out.println("This is running outside of a thread.");
        Thread.start();
    }
}