package src.merge_sort;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] a, int start, int end) {
        if (start < end) {

            int middle = start + (end - start) / 2;
            sort(a, start, middle);
            sort(a, middle + 1, end);
            merge(a, start, middle, end);
        }

    }

    public static void merge(int[] a, int start, int middle, int end) {
        int[] b = new int[a.length];
        for (int i = start; i <= end; i++) {
            b[i] = a[i];
        }
        int i = start;
        int j = middle + 1;

        for (int k = start; k <= end; k++) {
            if (i <= middle && j <= end) {
                if (b[i] < b[j]) {
                    a[k] = b[i++];
                } else {
                    a[k] = b[j++];
                }
            } else {
                if (i > middle) {
                    a[k] = b[j++];
                } else {
                    a[k] = b[i++];
                }
            }
        }
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);

    }

    public static void main(String[] args) {
        int[] c = { 20, 22, 19, 18 };
        System.out.println(Arrays.toString(c));
        sort(c);
        System.out.println(Arrays.toString(c));

    }
}