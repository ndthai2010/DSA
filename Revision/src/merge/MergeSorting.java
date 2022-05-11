package src.merge;

public class MergeSorting {
    
    private static void sort(int[] a, int start, int end){
        if(start < end){
            int middle = start + (end - start) / 2;
            sort(a, start, middle);
            sort(a, middle + 1, end);
            merge(a, start, middle, end);
        }
    }

    private static void merge(int[] a, int start, int middle, int end){
        int[] b = new int[a.length];
        for(int i = start; i <= end; i++){
            b[i] = a[i];
        }

        int i = start;
        int j = middle + 1;

        for(int idx = start; idx <= end; idx++){
            if(i < middle && j < end){
                if(b[i] < b[j]){
                    a[idx] = b[i++];
                }else{
                    a[idx] = b[j++];
                }
            }else{
                if(i >= middle){
                    a[idx] = b[j++];
                }else{
                    a[idx] = b[i++];
                }
            }
        }
    }

    public static void sort(int[] a){
        sort(a, 0, a.length - 1);
    }
}
