package com.company.DynamicProgramming;

import java.util.Scanner;

public class MinCountOfSquaresDP {
    private static int minSquareCount(int n){
        // for Numbers less than 3
        if(n <= 3){
            return n;
        }

        int []dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=2; i<=n; i++){
            int minCount = i;
            for(int j=1; j<=Math.sqrt(i); j++){
                int opt = 1 + dp[i-j*j];
                if(opt < minCount){
                    minCount = opt;
                }
            }
            dp[i] = minCount;
        }
        return dp[n];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minSquareCount(n));
    }
}
