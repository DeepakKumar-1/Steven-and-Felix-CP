package com.company.DynamicProgramming;

import java.util.Scanner;

public class MinCountOfSquaresMemoization {
    public static int minSquareCount(int n, int []dp){
        // if Result is Already Calculated
        if(dp[n] != -1){
            return dp[n];
        }
        // otherwise Calculate the result
        // Base Case
        if(n == 1){
            dp[n] = 1;
            return dp[n];
        }

        int minCount = n;
        for(int i=1; i<=Math.sqrt(n); i++){
            int opt = 1 + minSquareCount(n-i*i, dp);
            if(opt < minCount){
                minCount = opt;
            }
        }
        dp[n] = minCount;
        return dp[n];
    }
    private static int minSquareCount(int n){
        int []dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }
        return minSquareCount(n, dp);
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minSquareCount(n));
    }
}
