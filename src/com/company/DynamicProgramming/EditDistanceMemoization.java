package com.company.DynamicProgramming;

import java.util.Scanner;

public class EditDistanceMemoization {
    private static int editDist(String s, String t, int [][]dp){
        int n = s.length();
        int m = t.length();
        // if Result is Already Calculated
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        // otherwise Calculate the Result
        // Base Case
        if(n == 0){
            dp[n][m] = m;
            return dp[n][m];
        }
        if(m == 0){
            dp[n][m] = n;
            return dp[n][m];
        }

        // Compare first Character of Both Strings
        if(s.charAt(0) == t.charAt(0)){
            dp[n][m] = editDist(s.substring(1), t.substring(1), dp);
            return dp[n][m];
        }
        // Explore All Options
        int insert = editDist(s, t.substring(1), dp);
        int delete = editDist(s.substring(1), t, dp);
        int replace = editDist(s.substring(1), t.substring(1), dp);
        dp[n][m] = 1 + Math.min(insert, Math.min(delete, replace));
        return dp[n][m];
    }

    private static int editDist(String s, String t){
        int n = s.length();
        int m = t.length();
        int [][]dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j] = -1;
            }
        }
        return editDist(s, t, dp);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int res = editDist(s, t);
        System.out.println(res);
    }
}
