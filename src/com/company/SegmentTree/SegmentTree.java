package com.company.SegmentTree;

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
    }


}
