package src.recursion;

public class Binary {
    
    public static String binary(int n){
        if(n == 0){
            return "0";
        }
        String res = "";
        int temp = 0;
        while (n > 0) {
            temp = n % 2;
            res = temp + res;
            n = n % 2;
        }
        return res;
    }

    public static String recursionBinary(int n){
        if(n == 0){
            return "0";
        }

       if(n == 1){
           return "1";
       }

    return recursionBinary(n / 2) + recursionBinary(n % 2);
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(recursionBinary(n));
    }
}
