package src;

import java.util.Scanner;

public class InsertionPosition {
    public static Scanner sc = new Scanner(System.in);

    public static int getInsertPosition(int[] a, int x) {
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            if (x <= a[i]) {
                return i;
            }
        }
        return n;
    }

    public static void inputArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
    }

    public static void swapArray(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sortArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                swapArray(a, i, j);
            }
        }
    }

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] array = new int[n];
        inputArray(array);
        sortArray(array);
        getInsertPosition(array, x);
        printArray(array);

    }
}
