package src;

import java.util.Scanner;

public class Insert {

    public static Scanner sc = new Scanner(System.in);

    public static void insert(int[] a, int i, int x) {
        if (i == 0) {
            a[i] = x;
        } else {
            if (a[i - 1] > x) {
                a[i] = a[i - 1];
                insert(a, i - 1, x);
            } else {
                a[i] = x;
            }
        }
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] array = new int[n + 1];
        
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int x = sc.nextInt();
        insert(array, n, x);
        print(array);
    }
}
