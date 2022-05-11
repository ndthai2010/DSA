package src;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Binary {

    public static String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        String res = "";
        int temp = 0;
        while (n > 0) {
            temp = n % 2;
            res = temp + res;
            n = n / 2;
        }
        return res;

        /* Recursion
            if(n == 0) return "0";
            if(n == 1) return "1";
            return toBinary(n / 2) + toBinary(n % 2);
        */
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        int n = sc.nextInt();
        System.out.println("So " + n + " co dang nhi phan la: " + toBinary(n));
    }
}