import java.util.Iterator;
import  java.util.HashSet;
import java.util.Scanner;
public class Java_Exercise_3 {
    public static void main(String[] args) {
        HashSet<String> h = new HashSet<String>();
        h.add(args[0]);
        h.add(args[1]);
        h.add(args[2]);

        Iterator<String> iterator = h.iterator();
        while(iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }


    }
}