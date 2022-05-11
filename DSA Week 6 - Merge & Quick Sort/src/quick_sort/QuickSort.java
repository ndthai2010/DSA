package src.quick_sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = { 1000, 2, 5, 7, 1313, 5646, 34, 20, 12, 990 };
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int partition(int[] a, int start, int end) {
        int i = start + 1;
        int j = end;
        int pivot = a[start];

        /*
         * int a = {5,3,2,5,1,2,8,9,7} u = 0, v= 8 => key = a[u] = 5
         * B1: i = 1, j = 8
         * B2: i = 3
         * j = 5
         */

        while (i <= j) {
            while (i <= end && a[i] < pivot) {
                i++;
            }

            while (j >= start + 1 && a[j] >= pivot) {
                j--;
            }

            if (i < j) {
                swap(a, i, j);
                i++;
                i--;
            }
        }
        swap(a, start, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start < end) {
            int j = partition(a, start, end);
            quickSort(a, start, j - 1);
            quickSort(a, j + 1, end);
        }
    }

    public static void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }
}
