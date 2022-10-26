package com.company.DynamicProgramming;

import java.util.Scanner;

public class MinCountOfSquaresRecursion {
    private static int minSquareCount(int n){
        // Base case
        if(n == 1){
            return 1;
        }
            int minCount = n;
            for(int i=1; i<=Math.sqrt(n); i++){
                int opt = 1 + minSquareCount(n-i*i);
                if(opt < minCount){
                    minCount = opt;
                }
            }
            return minCount;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(minSquareCount(n));
    }
}
