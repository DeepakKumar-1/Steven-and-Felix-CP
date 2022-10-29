package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack01DP {
    private static int knapsack01(int []weight, int []profit, int maxWeight){
        int n = weight.length;
        int m = maxWeight;
        int [][]dp = new int[n+1][m+1];
        // Fill this Array
        // Values Corresponding to Base Case
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int w=0; w<=m; w++){
            dp[0][w] = 0;
        }

        // Fill Remaining Array
        for(int i=1; i<=n; i++){
            for(int w=1; w<=m; w++){
                if(weight[i-1] <= w){
                        dp[i][w] = Math.max(profit[i-1]+dp[i-1][w-weight[i-1]] , dp[i - 1][w]);
                }else{

                        dp[i][w] = dp[i - 1][w];
                }
            }
        }
        for(int []arr: dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[n][m];
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
