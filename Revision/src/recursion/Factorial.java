package src.recursion;

public class Factorial {

    public static int factorial1(int n){
        if(n <= 0){
            return 1;
        }else{
            return n * factorial1(n - 1);
        }
    }

    public static int factorial2(int n ){
        if(n <= 0){
            return 1;
        }else{
            return n * factorial2(n - 2);
        }
    } 

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial 1: " + factorial1(n));
        System.out.println("Factorial 2: " + factorial2(n));
        
    }
}
