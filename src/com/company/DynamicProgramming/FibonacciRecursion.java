package com.company.DynamicProgramming;

import java.util.Scanner;
public class FibonacciRecursion {

    private static void fib(int n){
        if(n == 0){
            System.out.print(n);
        }
        if(n == 1){
            System.out.print(0 + " " + 1);
        }
        else{
            int a = 0;
            int b = 1;
            System.out.print(a + " " + b + " ");
            for(int i=2; i<=n; i++){
                int c = a+b;
                System.out.print(c + " ");
                a = b;
                b = c;
            }
        }
    }
//    private static int fib(int n){
//        if(n < 0){
//            return -1;
//        }
//        if(n == 0 || n == 1){
//            return n;
//        }
//        return fib(n-1) + fib(n-2);
//    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fib(n);
//        System.out.println("Result: " + fib(n));
    }
}
