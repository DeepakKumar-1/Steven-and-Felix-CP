package com.company.SegmentTree;

import java.util.Scanner;

class Node{
    int maximum;
    int secondMaximum;
}

public class MaxPairSum {

    public static void createSegmentTree(int []arr, Node []st, int start, int end, int treeIndex){
        // in case of leaf Node
        if(start == end){
            Node node = new Node();
            node.maximum = arr[start];
            node.secondMaximum = Integer.MIN_VALUE;
            st[treeIndex] = node;
            return;
        }

        // find mid
        int mid = start + (end - start)/2;
        createSegmentTree(arr, st, start, mid, 2*treeIndex+1);
        createSegmentTree(arr, st, mid+1, end, 2*treeIndex+2);
        Node left = st[2*treeIndex+1];
        Node right = st[2*treeIndex+2];
        Node node = new Node();
        node.maximum = Math.max(left.maximum, right.maximum);
        node.secondMaximum = Math.min(Math.max(left.maximum, right.secondMaximum), Math.max(left.secondMaximum, right.maximum));
        st[treeIndex] = node;
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        Node []st = new Node[4*n];
        createSegmentTree(arr, st, 0, n-1, 0);

        for(int i=0; i<st.length; i++){
            if(st[i] != null) {
                System.out.println(st[i].maximum + ",  " + st[i].secondMaximum);
            } else{
                System.out.println(0 + ", " + 0);
            }
        }
    }
}
