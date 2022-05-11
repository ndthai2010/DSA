package src.sort;

public class Sorting {
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void bubbleSort(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] > a[j]){
                    swap(a, i, j);
                }
            }
        }
    }

    public static void selectionSort(int[] a){
        for(int i = 0; i < a.length; i++){
            for(int j = i + 1; j < a.length; j++){
                int min = a[i];
                if(min > a[j]){
                    swap(a, i, j);
                }
            }
        }
    }

    private static void shift(int[] a, int i){
        int temp = a[i];
        while(i > 0 && temp < a[i - 1]){
            temp = a[i - 1];
            i--;
        }
        temp = a[i - 1];
    }

    public static void insertionSort(int[] a, int n){
        for(int i = 0; i < n; i++){
             if(a[i] < a[i - 1]){
                 shift(a, i);
             }
        }
    }
    
}
