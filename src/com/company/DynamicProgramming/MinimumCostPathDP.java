package com.company.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumCostPathDP {
    public static int minCostPath(int [][]grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;
        int [][]dp = new int[n][m];
        dp[n-1][m-1] = grid[n-1][m-1];
        for(int c=m-2; c >= 0; c--){
            dp[n-1][c] = dp[n-1][c+1] + grid[n-1][c];
        }
        for(int r=n-2; r>=0; r--){
            dp[r][m-1] = dp[r+1][m-1] + grid[r][m-1];
        }
        for(int r=n-2; r >= 0; r--){
            for(int c=m-2; c>= 0; c--){
                int bottom = dp[r+1][c];
                int diagonal = dp[r+1][c+1];
                int straight = dp[r][c+1];
                dp[r][c] = grid[r][c]  + Math.min(bottom, Math.min(diagonal, straight));
            }
        }

        for(int []arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[0][0];
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
        Enter Number of Rows in Grid: 3
        Enter Number of Columns in Grid: 4
        Enter Entries Row wise:
        1 2 4 8
        9 5 1 6
        3 2 4 5
        [9, 8, 10, 19]
        [20, 11, 6, 11]
        [14, 11, 9, 5]
        Minimum Cost Path: 9
 */