package src.quick;

public class QuickSort {

    public static int partition(int[] a, int start, int end){
        int pivot = a[start];
        int i = start + 1;
        int j = end;

        do {
            while(i <= j && pivot >= a[i]){
                i++;
            }

            while(i <= j && pivot < a[j]){
                j--;
            }

            if(i < j){
                swap(a, i, j);
                i++;
                j--;

            }
        } while (i <= j);

        swap(a, pivot, j);
        return j;
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void sort(int[] a, int start, int end){
        int j = partition(a, start, end);
        if(start < end){
            sort(a, start, j - 1);
            sort(a, j + 1, end);
        }
    }

    public static void sort(int[] a){
        sort(a, 0, a.length - 1);
    }
}
