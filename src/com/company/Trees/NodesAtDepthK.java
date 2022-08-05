package com.company.Trees;

import java.util.Scanner;

public class NodesAtDepthK {

    public static void nodesAtDepthK(TreeNode root, int depth, int k){
        if(root == null){
            return;
        }

        if(depth == k){
            System.out.print(root.val + " ");
        }

        nodesAtDepthK(root.left, depth+1, k);
        nodesAtDepthK(root.right, depth+1, k);

    }

    public static void main(String []args){
        TreeNode root = new TreeNode(0);
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(22);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root.left = first;
        root.right = second;
        first.left = third;
        first.right = fourth;
        second.left = fifth;

        Scanner sc = new Scanner(System.in);
        System.out.print("K: ");
        int k = sc.nextInt();

        nodesAtDepthK(root, 0, k);
    }

}
