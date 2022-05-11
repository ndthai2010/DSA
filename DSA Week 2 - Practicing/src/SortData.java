package src;
import java.util.Random;

public class SortData {

    public static void sort(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (((Comparable) a[i]).compareTo(a[j]) > 0) {
                    Object temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static void shuffle(Comparable[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int j = rand.nextInt();
            Comparable temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
    }
}
