package src.recursion;

public class Fibonacci {
    
    public static int fib(int n){
        if(n < 2){
            return n;
        }else{
            return fib(n - 2) + fib(n - 1);
        }
    }
}
