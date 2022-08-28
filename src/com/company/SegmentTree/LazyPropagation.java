package com.company.SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class LazyPropagation {

    public static void buildTree(int []arr, int []st, int start, int end, int treeIndex){
        // in case of Leaf Node
        if(start == end){
            st[treeIndex] = arr[start];
            return;
        }
        // find Mid
        int mid = start + (end - start)/2;
        // build left SubTree
        buildTree(arr, st, start, mid, 2*treeIndex+1);
        // build Right SubTree
        buildTree(arr, st, mid+1, end, 2*treeIndex+2);
        st[treeIndex] = Math.min(st[2*treeIndex+1], st[2*treeIndex+2]);
    }

    public static void updateSegmentTreeLazy(int []st, int []lazy, int start, int end, int treeIndex, int l, int r, int inc){
        if(start > end){
            return;
        }
        if(lazy[treeIndex] != 0){
            st[treeIndex] += lazy[treeIndex];
            if(start != end) {
                lazy[2 * treeIndex + 1] = lazy[treeIndex];
                lazy[2 * treeIndex + 2] = lazy[treeIndex];
            }
            lazy[treeIndex] = 0;
        }

        // Case 1 : No Overlap i.e Completely Outside
        if(r < start || end < l){
            return;
        }

        // Complete Overlap
        if(start <= l && r <= end){
            st[treeIndex] += inc;
            if(start != end){
                lazy[2*treeIndex+1] += inc;
                lazy[2*treeIndex+2] += inc;
            }
            return;
        }

        // Partial Overlap
        int mid = start + (end - start)/2;
        updateSegmentTreeLazy(st, lazy, start, mid, 2*treeIndex+1, l, r, inc);
        updateSegmentTreeLazy(st, lazy, mid+1, end, 2*treeIndex+2, l, r, inc);
        st[treeIndex] = Math.min(st[2*treeIndex+1], st[2*treeIndex+2]);
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
        System.out.println(Arrays.toString(st));


        int []lazy = new int[3*n];
        updateSegmentTreeLazy(st, lazy, 0, n-1, 0, 0, 3, 2);
        System.out.println(Arrays.toString(st));
        System.out.println(Arrays.toString(lazy));
    }
}
