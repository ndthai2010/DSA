package src;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(rand.nextInt(100));
        }
        System.out.println("Mang ban dau: ");
        printList(list);
        list.set(2, 105);

        System.out.println("Mang thay doi lan 1: ");
        printList(list);
        
        System.out.println("Mang sau khi sort:");
        Collections.sort(list);
        printList(list);

        System.out.println("Mang sau khi shuffle: ");
        Collections.shuffle(list);
        printList(list);
    }

    public static void printList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
