package src;
import java.util.Arrays;
import java.util.Random;

public class Cards implements Comparable<Cards> {

    private int rank;
    private int suite;

    public Cards(int rank, int suite) {
        this.rank = rank;
        this.suite = suite;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getSuite() {
        return suite;
    }

    public void setSuite(int suite) {
        this.suite = suite;
    }

    private String getRankString() {
        if (rank == 1)
            return "A";
        if (rank == 11)
            return "J";
        if (rank == 12)
            return "Q";
        if (rank == 13)
            return "K";
        return rank + "";
    }

    private String getSuiteString() {
        if (suite == 1)
            return String.format("%c", 3);
        if (suite == 2)
            return String.format("%c", 4);
        if (suite == 3)
            return String.format("%c", 5);
        return String.format("%c", 6);
    }

    @Override
    public String toString() {
        return "[" + getRankString() + getSuiteString() + "]";
    }

    public static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int compareTo(Cards other) {
        if (this.rank > other.rank) {
            return other.rank - this.rank;
        }
        return this.suite - other.suite;
    }

    public static void shuffle(Comparable[] a) {
        int n = a.length;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int j = random.nextInt(n);
            Comparable temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i].compareTo(a[j]) > 0) {
                    Comparable temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 3; i <= 6; i++) {
            String t = String.format("%c", i);
            System.out.printf("A%s", t);
        }

        Cards[] desk = new Cards[52];
        int idx = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                desk[idx] = new Cards(j, i);
                idx++;
            }
        }

        printArray(desk);
        System.out.println("================================================");
        shuffle(desk);
        System.out.println("================================================");
        sort(desk);
        printArray(desk);
        System.out.println("================================================");
        Arrays.sort(desk);
        printArray(desk);
    }
}
