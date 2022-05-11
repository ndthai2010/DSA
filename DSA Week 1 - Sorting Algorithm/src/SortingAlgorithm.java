package src;

public class SortingAlgorithm {
    public static void leftToRightBubbleSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void rightToLeftBubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[i] < a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void leftToRightSelectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int min = a[i];
                if (min > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void rightToLeftSelectionSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int max = a[i];
                if (max < a[i]) {
                    swap(a, i, j);
                }
            }
        }
    }

    public static void leftToRightInsertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                shiftElement(a, i);
            }
        }
    }

    public static void rightToLeftInsertionSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i] > a[i - 1]) {
                shiftElement(a, i);
            }
        }
    }

    public static void shiftElement(int[] a, int i) {
        int iValue = a[i];
        while (i > 0 && a[i - 1] > iValue) {
            a[i] = a[i - 1];
            i--;
        }
        a[i] = iValue;
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = { 2, 5, 4, 1, 9, 8, 6, 3, 19 };
        System.out.println("Mang ban dau:");
        print(array);

        // leftToRightBubbleSort(array);
        rightToLeftBubbleSort(array);
        System.out.println("Mang sau khi sap xep theo Bubble Sort:");
        print(array);

        // leftToRightSelectionSort(array);
        rightToLeftSelectionSort(array);
        System.out.println("Mang sau khi sap xep theo kieu Selection Sort: ");
        print(array);

        // leftToRightInsertionSort(array2, 3);
        rightToLeftInsertionSort(array);
        System.out.println("Mang sau khi sap xep theo kieu Insertion Sort: ");
        print(array);
    }
}
