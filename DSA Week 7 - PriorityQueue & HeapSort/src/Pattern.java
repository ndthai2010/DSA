package src;

public class Pattern {
    public int match(int[] a, int[] b) {
        int result, idx, counter;
        for (int i = 0; i < b.length; i++) {
            idx = 0;
            counter = 0;
            result = i;
            for (int j = i; j < i + a.length; j++) {
                if (j < b.length && idx < a.length && b[j] == a[idx++]) {
                    if (++counter == a.length) {
                        return result;
                    }
                } else {
                    break;
                }
            }
        }

        return -1;
    }
}
