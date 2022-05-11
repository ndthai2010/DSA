package src.binary_search;

public class BinarySearch {

    public static boolean binarySearch(int[] array, int x, int start, int end) {
        if (start > end) {
            return false;
        }

        int middle = start + (end - start) / 2;

        if (array[middle] == x) {
            return true;
        } else if (x < array[middle]) {
            return binarySearch(array, x, start, middle - 1);
        } else {
            return binarySearch(array, x, middle + 1, end);
        }
    }

    public static boolean binarySearchIterative(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == x) {
                return true;
            } else if (x < array[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] array, int x) {
        return binarySearch(array, x, 0, array.length - 1);
    }
}
