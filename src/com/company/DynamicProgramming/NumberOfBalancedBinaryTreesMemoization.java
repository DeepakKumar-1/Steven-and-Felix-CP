package com.company.DynamicProgramming;

import java.util.Scanner;

public class NumberOfBalancedBinaryTreesMemoization {
    private static int countBalancedTrees(int h, int []dp){
        // if Result Already Calculated
        if(dp[h] != -1){
            return dp[h];
        }
        // otherwise Calculate the result
        // Base case
        if(h == 0 || h == 1){
            dp[h] = 1;
            return dp[h];
        }
        int x = countBalancedTrees(h-1);
        int y = countBalancedTrees(h-2);
        dp[h] = x*x + 2*x*y;
        return dp[h];
    }
    private static int countBalancedTrees(int h){
        int []dp = new int[h+1];
        for(int i=0; i<dp.length; i++){
            dp[i] = -1;
        }
        return countBalancedTrees(h, dp);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        System.out.println(countBalancedTrees(h));
    }
}
