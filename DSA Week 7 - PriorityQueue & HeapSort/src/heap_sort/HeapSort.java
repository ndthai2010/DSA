package src.heap_sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] data = { 0, 4, 6, 242, 1, 6, 7, 8, 2, 1, 664, 232, 7789, 33 };
        heapSort(data);

        System.out.println(Arrays.toString(data));
    }

    public static void heapSort(int[] a) {
        int n = a.length - 1;
        for (int k = n / 2; k > 0; k--) {
            downheap(a, k, n);
        }

        int t = n;
        while (t > 1) {
            swap(a, 1, t);
            t--;
            downheap(a, 1, t);
        }
    }

    private static void upheap(int[] a, int k) {
        while (k > 1 && a[k] > a[k / 2]) {
            swap(a, k, k / 2);
            k = k / 2;
        }
    }

    private static void downheap(int[] a, int k, int n) {
        while (2 * k < n) {
            int j = 2 * k;
            if (a[j] < a[j + 1]) {
                j++;
            }

            if (a[k] >= a[j]) {
                break;
            }

            swap(a, k, j);
            k = j;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
