package src;

public class TopK {
    public static int getTopk(int[] a, int k) {
        int n = a.length;
        int temp = a[0];
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[n - k];
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 2, 1, 4, 5, 7, 9, 8, 5, 6 };
        int k = 1;

        System.out.printf("Phần tử lớn thứ %d là: %d", k, getTopk(a, k));

    }
}