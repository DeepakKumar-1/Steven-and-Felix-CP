package com.company.DynamicProgramming;

import java.util.Scanner;

public class NumberOfBalancedBinaryTreesDP {
    private static int countBalancedTrees(int h){
        if(h <= 1){
            return 1;
        }
        int []dp = new int[h+1];
        // Entries Corresponds to Base Case
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=h; i++){
            dp[i] = dp[i-1] * dp[i-1] + 2 * dp[i-1] * dp[i-2];
        }
        return dp[h];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        System.out.println(countBalancedTrees(h));
    }
}
