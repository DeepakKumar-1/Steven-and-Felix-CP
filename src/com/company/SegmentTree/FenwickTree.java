package com.company.SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class FenwickTree {
    public static void update(int index, int value, int []BIT, int n){
        for(; index <= n; index += index&(-index)){
            BIT[index] += value;
        }
    }

    public static int query(int index, int []BIT){
        int sum = 0;
        for(; index > 0; index -= index&(-index)){
            sum += BIT[index];
        }
        return sum;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n+1];
        int []BIT = new int[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
            update(i, arr[i], BIT, n);
        }
        System.out.println(Arrays.toString(BIT));
        int ans = query(3, BIT);
        System.out.println(ans);
    }
}
