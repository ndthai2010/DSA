package src;

public class RLE {
    /**
     * Computes the length of the compression array.
     * 
     * @param t a binary array
     * @return an integer.
     */
    public static int length(int[] t) {
        if (t.length == 0 || t == null) {
            return 0;
        }

        int count = 1;
        for (int i = 0; i < t.length; i++) {
            if (t[i] != t[i - 1]) {
                count++;
            }
        }
        return 2 * count;
    }

    /**
     * Compresses an array in RLE format and return the result.
     * 
     * @param t
     * @return compressed array.
     */
    public static int[] compress(int[] t) {
        int[] compression = new int[length(t)];
        if (t.length == 0 || t == null) {
            return compression;
        }

        int idx = 0;
        for (int i = 0; i < t.length; i++) {
            int count = 1;
            compression[idx] = t[i];
            while (i < t.length - 1 && t[i] == t[i + 1]) {
                count++;
                i++;
            }
            compression[++idx] = count;
            idx++;
        }
        return compression;
    }

    /**
     * Computes the length of the decompressed array.
     * 
     * @param t
     * @return an integer.
     */
    public static int lengthInverse(int[] t) {
        // TODO: Your code here
        if (t.length == 0 || t == null) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < t.length; i += 2) {
            sum += t[i];
        }
        return sum;
    }

    /**
     * Decompresses the array.
     * 
     * @param t
     * @return an array
     */
    public static int[] decompress(int[] t) {
        if (t.length == 0 || t == null) {
            return new int[0];
        }
        int[] decompression = new int[lengthInverse(t)];
        int count = 0;
        for (int i = 0; i < t.length; i += 2) {
            for (int j = 0; j < t[i]; j++) {
                decompression[count] = t[i];
                count++;
            }
        }
        return decompression;
    }
}
