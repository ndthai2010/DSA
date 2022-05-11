package src.merge;

public class Merge {
    
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;

        for(int k = 0; k < c.length; k++) {
            if(i < a.length && j < b.length){
                if(a[i] < b[j]){
                    c[k] = a[i++];
                }else{
                    c[k] = b[j++];
                }
            }else{
                if(i >= a.length){
                    c[k] = b[j++];
                }else{
                    c[k] = a[i++];
                }
            }
        }
        return c;
    }
}
