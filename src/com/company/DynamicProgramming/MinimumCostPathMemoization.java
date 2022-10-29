package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCostPathMemoization {
    private static int minCostPath(int [][]grid, int row, int col, int [][]dp){
        // Edge Cases
        if(row >= grid.length || col >= grid[0].length){
            return Integer.MAX_VALUE;
        }

        // if Result is Already Calculated then Return the Result
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        // otherwise Calculate
        // Base case
        if(row == grid.length-1 && col == grid[0].length-1){
            dp[row][col] = grid[row][col];
            return dp[row][col];
        }

        int bottom = minCostPath(grid, row+1, col, dp);
        int diagonal = minCostPath(grid, row+1, col+1, dp);
        int straight = minCostPath(grid, row, col+1, dp);
        dp[row][col] = grid[row][col] + Math.min(bottom, Math.min(diagonal, straight));
        return dp[row][col];
    }
    private static int minCostPath(int [][]grid, int row, int col){
        int [][]dp = new int[grid.length][grid[0].length];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return minCostPath(grid, row, col, dp);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Rows in Grid: ");
        int n = sc.nextInt();
        System.out.print("Enter Number of Columns in Grid: ");
        int m = sc.nextInt();
        int [][]grid = new int[n][m];
        System.out.print("Enter Entries Row wise: ");
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int res = minCostPath(grid, 0, 0);
        System.out.println("Minimum Cost Path: " + res);
    }
}


/*
        1 2 4 8
        9 5 1 6
        3 2 4 5

        res : 9
*/