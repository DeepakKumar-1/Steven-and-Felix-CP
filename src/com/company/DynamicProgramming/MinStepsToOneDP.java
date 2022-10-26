package com.company.DynamicProgramming;

import java.util.Scanner;

public class MinStepsToOneDP {
    private static int minSteps(int n){
        int []dp = new int[n+1];
        // Entries Corresponds to Base Case
        dp[1] = 0;
        for(int i=2; i<=n; i++){
            // Explore All Options
            int opt2, opt3;
            opt2 = opt3 = Integer.MAX_VALUE;
            int opt1 = dp[i-1];
            if(i%2 == 0){
                opt2 = dp[i/2];
            }
            if(i%3 == 0){
                opt3 = dp[i/3];
            }
            dp[i] = 1+Math.min(opt1, Math.min(opt2, opt3));
        }
        return dp[n];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minSteps(n));
    }
}
