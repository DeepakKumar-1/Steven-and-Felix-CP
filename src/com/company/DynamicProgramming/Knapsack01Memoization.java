package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack01Memoization {
    private static int knapsack01(int []weight, int []profit, int maxWeight, int i, int [][]dp){
        int n = i;
        int m = maxWeight;
        // Base Case
        if(i >= weight.length || maxWeight == 0){
            dp[n][m] = 0;
            return dp[n][m];
        }

        // if Result is Already Calculated
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        // otherwise Calculate the result
        if(weight[i] <= maxWeight){
            // include this item
            int opt1 = profit[i] + knapsack01(weight, profit, maxWeight-weight[i], i+1, dp);

            // Don't Include this item
            int opt2 = knapsack01(weight, profit, maxWeight, i+1, dp);
            dp[n][m] = Math.max(opt1, opt2);
            return dp[n][m];
        }else{
            dp[n][m] = knapsack01(weight, profit, maxWeight, i+1, dp);
            return dp[n][m];
        }
    }
    private static int knapsack01(int []weight, int []profit, int maxWeight){
        int n = profit.length;
        int m = maxWeight;
        int [][]dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j] = -1;
            }
        }
        int ans = knapsack01(weight, profit, maxWeight, 0, dp);
        for(int []arr: dp){
            System.out.println(Arrays.toString(arr));
        }
        return ans;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Max Weight: ");
        int maxWeight = sc.nextInt();
        System.out.print("Enter Number of Items: ");
        int n = sc.nextInt();
        int []weight = new int[n];
        int []profit = new int[n];
        System.out.print("Enter Weights: ");
        for(int i=0; i<weight.length; i++){
            weight[i] = sc.nextInt();
        }
        System.out.print("Enter Profits: ");
        for(int i=0; i<profit.length; i++){
            profit[i] = sc.nextInt();
        }
        int maxProfit = knapsack01(weight, profit, maxWeight);
        System.out.println(maxProfit);
    }
}
