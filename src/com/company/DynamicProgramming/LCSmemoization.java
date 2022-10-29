package com.company.DynamicProgramming;

import java.util.Scanner;

public class LCSmemoization {
    private static int LCS(String s, String t, int [][]dp){
        int n = s.length();
        int m = t.length();
        // if Result Already Calculated
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        // otherwise calculate result
        // Base Case
        if(s.isEmpty() || t.isEmpty()){
            dp[n][m] = 0;
            return dp[n][m];
        }

        if(s.charAt(0) == t.charAt(0)){
            dp[n][m] = 1 + LCS(s.substring(1), t.substring(1), dp);
            return dp[n][m];
        }
        int opt1 = LCS(s.substring(1), t, dp);
        int opt2 = LCS(s, t.substring(1), dp);
        int opt3 = LCS(s.substring(1), t.substring(1), dp);
        dp[n][m] = Math.max(opt1, Math.max(opt2, opt3));
        return dp[n][m];
    }
    private static int LCS(String s, String t){
        int n = s.length();
        int m = s.length();
        int [][]dp = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j] = -1;
            }
        }
        return LCS(s,t, dp);
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int res = LCS(s, t);
        System.out.println(res);
    }
}
