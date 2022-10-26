package com.company.DynamicProgramming;

import java.util.Scanner;

public class MinStepsToOneMemoization {
    private static int minSteps(int n, int []dp){
        // if Result is Already Calculated
        if(dp[n] != -1){
            return dp[n];
        }
        // Otherwise Calculate the Result
        // Base Case
        if(n == 1){
            dp[n] = 0;
            return dp[n];
        }
        // Explore All three Options
        int opt2, opt3;
        opt2 = opt3  = Integer.MAX_VALUE;
        int opt1 = minSteps(n-1, dp);
        if(n % 2 == 0){
            opt2 = minSteps(n/2, dp);
        }
        if(n % 3 == 0){
            opt3 = minSteps(n/3, dp);
        }
        dp[n] = 1 + Math.min(opt1, Math.min(opt2, opt3));
        return dp[n];
    }
    private static int minSteps(int n){
        int []dp = new int[n+1];
        for(int i=0; i < dp.length; i++){
            dp[i] = -1;
        }
        return minSteps(n, dp);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minSteps(n));
    }
}
