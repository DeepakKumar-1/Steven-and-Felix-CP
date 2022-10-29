package com.company.DynamicProgramming;

import java.util.Scanner;

public class MinimumCostPathRecursion {
    private static int minCostPath(int [][]grid, int i, int j){
        // Base Case
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        if(i >= grid.length || j >= grid.length){
            return Integer.MAX_VALUE;
        }
        // Explore All Possible Directions
        int bottom = minCostPath(grid, i+1, j);
        int straight = minCostPath(grid, i, j+1);
        int diagonal = minCostPath(grid, i+1, j+1);
        return grid[i][j] + Math.min(bottom, Math.min(straight, diagonal));
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
