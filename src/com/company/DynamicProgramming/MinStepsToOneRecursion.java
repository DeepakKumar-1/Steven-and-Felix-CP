package com.company.DynamicProgramming;

import java.util.Scanner;

public class MinStepsToOneRecursion {
    private static int minSteps(int n){
        // Base Case
        if(n == 1){
            return 0;
        }

        // Explore All Options
        int opt2 , opt3;
        opt2 = opt3 = Integer.MAX_VALUE;
        int opt1 = minSteps(n-1);
        if(n%2 == 0) {
            opt2 = minSteps(n / 2);
        }
        if(n%3 == 0){
            opt3 = minSteps(n/3);
        }
        return 1 + Math.min(opt1, Math.min(opt2, opt3));
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = minSteps(n);
        System.out.println(res);
    }
}
