package com.company.SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfSquares {
    public static void buildTree(int []arr, int []st, int start, int end, int treeIndex){
        // if node is leaf Node
        if(start == end){
            st[treeIndex] = arr[start];
            return;
        }

        // find Mid
        int mid = start + (end - start)/2;
        // build left Subtree
        buildTree(arr, st, start, mid, 2*treeIndex+1);
        // build right Subtree
        buildTree(arr, st, mid+1, end, 2*treeIndex+2);
        st[treeIndex] = (int)Math.pow(st[2*treeIndex+1], 2) + (int)Math.pow(st[2*treeIndex+2], 2);
    }

    public static int query(int []st, int start, int end, int treeIndex, int l, int r){
        // case1 : Completely outside or No Overlap
        if(end < l || r < start){
            return 0;
        }

        // case2 : Completely inside or Overlap
        if(l <= start && end <= r){
            return st[treeIndex];
        }

        // case3 : Partially inside or Partially Outside / partial overlap
        int mid = start + (end - start)/2;
        int ans1 = query(st, start, mid, 2*treeIndex+1, l, r);
        int ans2 = query(st, mid+1, end, 2*treeIndex+2, l, r);
        return ans1+ans2;
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int []st = new int[3*n];
        buildTree(arr, st, 0, n-1, 0);
        // print tree
        System.out.println(Arrays.toString(st));

        int l = sc.nextInt();
        int r = sc.nextInt();
        int ans = query(st, 0, n-1, 0, l, r);
        System.out.println(ans);
    }
}
