package com.company.Trees;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
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

        int diameter = findDiameter(root);
        System.out.println(diameter);
    }

    public static int findDiameter(TreeNode root){
        // Base Case
        if(root == null){
            return 0;
        }


        int opt1 = height(root.left) + height(root.right);
        int opt2 = findDiameter(root.left);
        int opt3 = findDiameter(root.right);
        return Math.max(opt1 , Math.max(opt2, opt3));
    }

    private static int height(TreeNode root){
        // Base Case
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left) , height(root.right)) + 1;
    }
}


