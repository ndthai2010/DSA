package src.sort;

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

    public int getSuite() {
        return suite;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setSuite(int suite) {
        this.suite = suite;
    }

    private String getRankString() {
        if(rank == 1){
            return "A";
        }
        if(rank == 11){
            return "J";
        }
        if(rank == 12){
            return "Q";
        }
        if(rank == 13){
            return "K";
        }
        return rank + "";
    }

    private String getSuiteString() {
        if(suite == 1){
            return String.format("%c", 3);
        }
        if(suite == 2){
            return String.format("%c", 4);
        }
        if(suite == 3){
            return String.format("%c", 5);
        }
        return String.format("%c", 6);
    }

    

    @Override
    public int compareTo(Cards other) {
        // TODO Auto-generated method stub
        if(this.rank > other.rank) {
            return other.rank - this.rank;
        }
        return this.suite - other.suite;
    }

    @Override
    public String toString() {
        return "[" + getRankString() + getSuiteString() + "]";
    }


    public static void print(Object[] a){
        for(int  i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void shuffle(Comparable[] a){
        int n = a.length;
        Random random = new Random();

        for(int i = 0; i < n; i++){
            int j = random.nextInt(n);
            Comparable temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void sort(Comparable[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i].compareTo(a[j]) > 0){
                    Comparable temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
