package com.company.Backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class NQueens {
    public static void nQueens(int n){
        char [][]board = new char[n][n];
        solve(board, 0, 0);
    }
    private static boolean isSafe(char [][]board, int r, int c){
        int n = board.length;
        // Vertical Checking
        for(int i=0; i<n; i++){
            if(board[i][c] == 'Q'){
                return false;
            }
        }

        // Diagonal Checking


    }
    private static void solve(char [][]board, int r, int c){
        int n = board.length;
        // Edge Cases
        if(r >= n || c >= n){
            return;
        }

        // check if the Current Cell is Safe
        // if Safe then Place Queen Here
        for(int i = 0; i < n; i++) {
            if (isSafe(board, r, c)) {
                board[r][c] = 'Q';
                break;
            }
        }

        if(r == n-1){
            // Display Board
            for(char []row : board){
                System.out.println(Arrays.toString(row));
            }
        }
        solve(board, r+1, c);
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nQueens(n);
    }
}
