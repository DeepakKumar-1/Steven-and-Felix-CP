package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FactorialUsingDP {
    private static int fact(int n){
        int []dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = i*dp[i-1];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fact(n));
    }
}
