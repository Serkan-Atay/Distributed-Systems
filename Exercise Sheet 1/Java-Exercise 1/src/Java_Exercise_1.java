public class Java_Exercise_1 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
    public static int factorial(int a) {
        if(a == 1) {
            return 1;
        } else {
            return a * factorial(a - 1);
        }
    }
}