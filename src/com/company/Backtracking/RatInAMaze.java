package com.company.Backtracking;

public class RatInAMaze {
    private static boolean ratInAMaze(int [][]grid){
        return ratInAMaze(grid, 0, 0);
    }

    private static boolean ratInAMaze(int [][]grid, int r, int c){
        int n = grid.length;
        int m = grid[0].length;
        // Base Case
        if(r == n-1 && c == m-1 && grid[r][c] == 1){
            return true;
        }
        // Edge Cases
        if(r < 0 || r >=n || c < 0 || c >= m){
            return false;
        }
        if(grid[r][c] == 0){
            return false;
        }
        // Two Possible Direction
        // Go Right
        boolean right = ratInAMaze(grid, r, c+1);
        // Go Bottom
        boolean bottom = ratInAMaze(grid, r+1, c);
        return right || bottom;
    }

    public static void main(String []args){
        int [][]grid = {{1, 1, 0},
                        {1, 1, 0},
                        {1, 1, 0}};
        System.out.println(ratInAMaze(grid));
    }
}
