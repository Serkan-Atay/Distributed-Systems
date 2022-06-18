import java.util.Scanner;
public class Java_Exercise_4 extends Thread {
    public void attribute(int number) {
        for (int i = 0; i < 5; i++) {
            //if (i == 2 || i == 4) {
                //Thread.sleep(3000);
            //}
            System.out.println(number);
        }
    }
    public void userInput() {
        Java_Exercise_4 Thread = new Java_Exercise_4();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Thread.attribute(0);
    }
    public static void main(String[] args) {
        Java_Exercise_4 Thread = new Java_Exercise_4();

        Thread.userInput();
    }
}