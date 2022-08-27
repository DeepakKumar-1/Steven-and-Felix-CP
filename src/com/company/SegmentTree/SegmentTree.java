package com.company.SegmentTree;

import com.company.Trees.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SegmentTree {

    private static void createSegmentTree(int[] arr,int []segmentTree,  int start, int end, int index){
        // Case of Leaf Node
        if(start == end){
            segmentTree[index] = arr[start];
            return;
        }

        // find Mid
        int mid = start + (end - start)/2;
        createSegmentTree(arr,segmentTree, start, mid, (2*index+1));
        createSegmentTree(arr, segmentTree,mid+1, end, (2*index+2));
        segmentTree[index] = segmentTree[(2*index+1)] + segmentTree[(2*index+2)];
    }


    public static void updateTree(int []arr, int []segmentTree, int start, int end, int TreeIndex, int updateIndex, int val){
        if(start == end){
            arr[updateIndex] = val;
            segmentTree[TreeIndex] = val;
            return;
        }

        int mid = start + (end - start)/2;
        if(updateIndex > mid){
            // go towards right subtree
            updateTree(arr, segmentTree, mid+1, end, 2*TreeIndex  + 2, updateIndex, val);
        } else{
            // go towards left subtree
            updateTree(arr, segmentTree, start, mid, 2*TreeIndex  + 1, updateIndex, val);
        }

        segmentTree[TreeIndex] = segmentTree[(2*TreeIndex+1)] + segmentTree[(2*TreeIndex+2)];
    }

    public static int sum(int []segmentTree, int start, int end, int treeIndex, int left, int right){
        // case 1 : Completely Outside the Given range
        if(start > right || end < left){
            return 0;
        }
        // case 2 : Completely Inside the Given range
        if(start >= left && end <= right){
            return segmentTree[treeIndex];
        }
        // case 3 : Partially  Inside and Partially Outside the Given range
        int mid = start + (end - start)/2;
        int ans1 = sum(segmentTree, start, mid, 2*treeIndex+1, left, right);
        int ans2 = sum(segmentTree, mid+1, end, 2*treeIndex+2, left, right);
        return ans1+ans2;
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        // Take size of Array
        int size = sc.nextInt();
        int []arr = new int[size];
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int n = arr.length;
        int x = (int)(Math.ceil(Math.log(n)/Math.log(2))); //Height of segment tree
        int max_size = 2*(int)Math.pow(2, x) - 1; //Maximum size of segment tree
        int [] segmentTree = new int[max_size];
        createSegmentTree(arr, segmentTree, 0, arr.length-1, 0);
        System.out.println(Arrays.toString(segmentTree));

        updateTree(arr, segmentTree, 0, arr.length-1, 0, 2, 10);
        System.out.println(Arrays.toString(segmentTree));


        // Query
        int ans = sum(segmentTree, 0, arr.length-1, 0, 2, 4);
        System.out.println(ans);

    }


}
