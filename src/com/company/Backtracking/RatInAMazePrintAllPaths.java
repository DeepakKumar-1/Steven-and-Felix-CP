package com.company.Backtracking;

import java.util.Arrays;


public class RatInAMazePrintAllPaths {
    public static void ratInAMaze(int [][]grid){
        int n = grid.length;
        int m = grid[0].length;
        int [][]path = new int[n][m];
        solveMaze(grid, 0, 0, path);
    }
    private static void solveMaze(int [][]grid, int r, int c, int [][]path){
        int n = grid.length;
        int m = grid[0].length;

        // Edge Cases and Wrong Cell case
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0 || path[r][c] == 1){
            return;
        }


        // Base Case
        if(r == n-1 && c == m-1){
            path[r][c] = 1;
            // Print Path
            for(int []row : path){
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
            path[r][c] = 0;
            return;
        }

        // Explore all Possible Directions
        // Mark current Cell as Visited
        path[r][c] = 1;
        // Right
        solveMaze(grid, r, c+1, path);
        // left
        solveMaze(grid, r, c-1, path);
        // top
        solveMaze(grid, r-1, c, path);
        // bottom
        solveMaze(grid, r+1, c, path);

        path[r][c] = 0;
    }
    public static void main(String []args){

        int [][]grid = {{1, 1, 0},
                        {1, 1, 0},
                        {1, 1, 1}};
         ratInAMaze(grid);
    }
}
