package com.company.DynamicProgramming;

import java.util.Scanner;

public class NumberOfBalanceBinaryTreesOfHeightH {
    private static int countBalancedTree(int h){
        // base case
        if(h == 0 || h == 1){
            return 1;
        }
        int x = countBalancedTree(h-1);
        int y = countBalancedTree(h-2);
        return x*x  + 2*x*y;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Height of Tree: ");
        int h = sc.nextInt();
        System.out.println("Number of Possible Binary Trees of Height " + h + " is: " + countBalancedTree(h));
    }
}
