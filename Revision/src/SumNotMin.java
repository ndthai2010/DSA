package src;

public class SumNotMin {
    
    public static void main(String[] args) {
        
    }

    public static int sumNotMin(int[] a){
        int min = a[0];
        int sum = 0;
        int finalSum = 0;
        int count = 1;

        for(int i = 1; i < a.length; i++){
            if(min > a[i]){
                min = a[i];
                count = 1;
            }else if (min == a[i]){
                count++;
            }
            sum += a[i];
        }
        finalSum = sum - count * min;
        return finalSum;
    }
}
