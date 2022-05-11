package src.quick_sort;

public class QuickArray {

    public int partition(int[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        double avg = sum / a.length;

        int key = a[0];
        int idx = 0;

        for (int i = 1; i < a.length; i++) {
            if (Math.abs(a[i] - avg) < (Math.abs(key - avg))) {
                key = a[i];
                idx = i;
            }

            if (Math.abs(a[i] - avg) == (Math.abs(key - avg)) && a[i] < key) {
                key = a[i];
                idx = i;
            }
        }
        swap(a, idx, 0);

        int i = 1;
        int j = a.length - 1;

        while (i <= j) {
            while (i < a.length && a[i] < key) {
                i++;
            }

            while (j > 0 && a[j] >= key) {
                j--;
            }

            if (i < j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, 0, j);
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
