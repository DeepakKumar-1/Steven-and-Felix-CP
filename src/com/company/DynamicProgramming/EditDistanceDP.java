package com.company.DynamicProgramming;

import java.util.Scanner;

public class EditDistanceDP {
    private static int editDist(String s, String t){
        int n = s.length();
        int m = t.length();
        int [][]dp = new int[n+1][m+1];
        // Fill the Dp Array Corresponds to Base Case
        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=m; j++){
            dp[0][j] = j;
        }
        // Fill the Remaining Dp Array
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s.charAt(n-i) == t.charAt(m-j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int res = editDist(s, t);
        System.out.println(res);
    }
}
