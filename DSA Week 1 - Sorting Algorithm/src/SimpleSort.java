package src;

import java.util.Comparator;
import java.util.Random;

@SuppressWarnings("unchecked")
public class SimpleSort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i].compareTo(a[j]) > 0) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static <T> void sort(T[] a, Comparator<T> compare) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (compare.compare(a[i], a[j]) > 0) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shuffle(Object[] a) {
        int n = a.length;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            Object temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void print(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        Integer[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 == o2 % 2)
                    return o1 - o2;
                else
                    return o1 % 2 - o2 % 2;
            }
        };

        sort(a, comp);
        print(a);
    }
}
