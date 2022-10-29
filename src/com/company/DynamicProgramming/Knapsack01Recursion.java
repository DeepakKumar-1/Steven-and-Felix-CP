package com.company.DynamicProgramming;

import java.util.Scanner;

public class Knapsack01Recursion {
    private static int knapsack01(int []weight, int []profit, int maxWeight, int i){
        // Base Case
        if(i == weight.length || maxWeight == 0){
            return 0;
        }

        if(weight[i] > maxWeight){
            return knapsack01(weight, profit, maxWeight, i+1);
        }else{
            // Include
            int opt1 = profit[i] + knapsack01(weight, profit, maxWeight - weight[i], i+1);
            // don't Include
            int opt2 = knapsack01(weight, profit, maxWeight, i+1);
            return Math.max(opt1, opt2);
        }
    }

    private static int knapsack01(int []weight, int []profit, int maxWeight){
        return knapsack01(weight, profit, maxWeight, 0);
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int maxWeight = sc.nextInt();
        System.out.print("Enter Number of Items: ");
        int n = sc.nextInt();
        int []weight = new int[n];
        int []profit = new int[n];
        System.out.print("Enter Weights: ");
        for(int i=0; i<weight.length; i++){
            weight[i] = sc.nextInt();
        }
        System.out.print("Enter Profits: ");
        for(int i=0; i<profit.length; i++){
            profit[i] = sc.nextInt();
        }
        int maxProfit = knapsack01(weight, profit, maxWeight);
        System.out.println(maxProfit);
    }










//    private static int knapsack01(int []weight, int []profit, int maxWeight, int i, int bagWeight){
//        // Base Case
//        if(i == weight.length-1 && weight[i] + bagWeight <= maxWeight){
//            return profit[i];
//        }
//        if(i >= weight.length){
//            return Integer.MIN_VALUE;
//        }
//
//        if(weight[i] + bagWeight <= maxWeight){
//            // Include
//            int opt1 = profit[i] + knapsack01(weight, profit, maxWeight, i+1, bagWeight+weight[i]);
//            // Not Include
//            int opt2 = knapsack01(weight, profit, maxWeight, i+1, bagWeight);
//            return Math.max(opt1, opt2);
//        }else{
//            return  knapsack01(weight, profit, maxWeight, i+1, bagWeight);
//        }
//    }
}
