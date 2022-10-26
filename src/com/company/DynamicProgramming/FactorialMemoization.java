package com.company.DynamicProgramming;
import java.util.*;
public class FactorialMemoization {
    private static int fact(int n, int []dp){
        // if Result Already Calculated
        if(dp[n] != -1){
            return dp[n];
        }
        // otherwise Calculate
        // Base Case
        if(n == 0 || n == 1){
            dp[n] = 1;
            return dp[n];
        }
        dp[n] = n*fact(n-1, dp);
        return dp[n];
    }
    private static int fact(int n){
        int []dp = new int[n+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        return fact(n, dp);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }
}
