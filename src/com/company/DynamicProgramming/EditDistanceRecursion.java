package com.company.DynamicProgramming;

import java.util.Scanner;

public class EditDistanceRecursion {
    private static int editDist(String s, String t){
        // Base Case
        if(s.isEmpty()){
            return t.length();
        }
        if(t.isEmpty()){
            return s.length();
        }

        // check first Character of both Strings
        if(s.charAt(0) == t.charAt(0)){
            return editDist(s.substring(1), t.substring(1));
        }
        // insert a Character
        int opt1 = editDist(s, t.substring(1));
        // Delete a Character
        int opt2 = editDist(s.substring(1), t);
        // Replace a Character
        int opt3 = editDist(s.substring(1), t.substring(1));
        return 1 + Math.min(opt1, Math.min(opt2, opt3));
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int res = editDist(s, t);
        System.out.println(res);
    }
}
