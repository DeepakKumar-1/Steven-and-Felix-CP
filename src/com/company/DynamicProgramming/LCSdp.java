package com.company.DynamicProgramming;

import java.util.Scanner;

public class LCSdp {
    public static int LCS(String s, String t){
        int n = s.length();
        int m = s.length();
        int [][]dp = new int[n+1][m+1];
        // Fill Values Corresponds to Base Case
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(n-i) == s.charAt(m-j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int opt1 = dp[i-1][j];
                    int opt2 = dp[i-1][j-1];
                    int opt3 = dp[i][j-1];
                    dp[i][j] = Math.max(opt1, Math.max(opt2, opt3));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int res = LCS(s, t);
        System.out.println(res);
    }
}
