package com.company.DynamicProgramming;

import java.util.Scanner;

public class FibonacciUsingMemoization {
    private static int fib(int n){
        int []dp = new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        return fib(n, dp);
    }
    private static int fib(int n, int []dp){
        // if Result Already Calculate then return result
        if(dp[n] != -1){
            return dp[n];
        }
        // otherwise Calculate the Result
        // Base Case
        if(n == 0 || n == 1){
            dp[n] = n;
            return dp[n];
        }
        dp[n] = fib(n-1, dp) + fib(n-2, dp);
        return dp[n];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Any Number: ");
        int n = sc.nextInt();
        int res = fib(n);
        System.out.println(res);
    }
}
