package com.company.Backtracking;

import java.util.Arrays;

public class RatInAMaze2 {
    public static boolean ratInAMaze(int [][]grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean [][]visited = new boolean[n][m];
        return ratInAMaze(grid, 0, 0, visited);
    }
    public static boolean ratInAMaze(int [][]grid, int r, int c, boolean [][]visited){
        int n = grid.length;
        int m = grid[0].length;

        // Edge Case
        if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0 || visited[r][c]){
            return false;
        }

        // mark Current Cell as Visited
        visited[r][c] = true;

        // Base Case i.e Destination Cell
        if(r == n-1 && c == m-1 && grid[r][c] == 1){
            // Print Path
            for(boolean []row : visited) {
                System.out.println(Arrays.toString(row));
            }
            return true;
        }

        // Explore All Possible Directions
        // Go Right
        boolean right = ratInAMaze(grid, r, c+1, visited);
        // Go Left
        boolean left = ratInAMaze(grid, r, c-1, visited);
        // Go Bottom
        boolean bottom = ratInAMaze(grid, r+1, c, visited);
        // Go Top
        boolean top = ratInAMaze(grid, r-1, c, visited);
        visited[r][c] = false;
        return right || left || bottom || top;

    }
    public static void main(String []args){
        int [][]grid = {{1, 1, 0},
                        {0, 1, 0},
                        {1, 1, 1}};
        System.out.println(ratInAMaze(grid));
    }
}
