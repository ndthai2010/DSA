package src.merge_sort;

public class MergeArray {
    
    public int[] mergeArray(int[] a, int[] b){
        int[] c = new int[a.length + b.length];

        int i = 0, j = 0;

        for(int idx = 0; idx < c.length; idx++){
            if(i < a.length && j < b.length) {
                if(a[i] < b[j]){
                    c[idx] = a[i++];
                }else{
                    c[idx] = b[j++];
                }
            }else{
                if(i >= a.length){
                    c[idx] = b[j++];
                }else{
                    c[idx] = a[i++];
                }
            }
        }
        return c;
    }

    
}
