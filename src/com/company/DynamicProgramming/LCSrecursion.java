package com.company.DynamicProgramming;

import java.util.Scanner;

public class LCSrecursion {
    private static int LCS(String s, String t){
        // Base Case
        if(s.isEmpty() || t.isEmpty()){
            return 0;
        }
        // if First Character of Both Strings are Equal
        if(s.charAt(0) == t.charAt(0)){
            return 1 + LCS(s.substring(1), t.substring(1));
        }
        int opt1 = LCS(s, t.substring(1));
        int opt2 = LCS(s.substring(1), t);
        int opt3 = LCS(s.substring(1), t.substring(1));
        return Math.max(opt1, Math.max(opt2, opt3));
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int res = LCS(s, t);
        System.out.println(res);
    }
}
