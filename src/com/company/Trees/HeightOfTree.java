package com.company.Trees;

public class HeightOfTree {

    public static int treeHeight(TreeNode root){
        // Base Case
        if(root == null || root.left == null && root.right == null){
            return 0;
        }

        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        return 1 + Math.max(left, right);
    }

    public static void main(String []args){
        TreeNode root = new TreeNode(0);
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);

        root.left = first;
        root.right = second;
        first.left = third;
        first.right = fourth;
        second.left = fifth;

        int height = treeHeight(root);
        System.out.println(height);
    }

}
