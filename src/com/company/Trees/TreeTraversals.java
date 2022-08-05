package com.company.Trees;

public class TreeTraversals {
    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        TreeNode first = new TreeNode(2);
        TreeNode second = new TreeNode(3);
        TreeNode third = new TreeNode(4);
        TreeNode fourth = new TreeNode(5);
        TreeNode fifth = new TreeNode(6);

        root.left = first;
        root.right = second;
        first.left = third;
        first.right = fourth;
        second.left = fifth;

        System.out.print("PreOrder Traversal: ");
        preOrderTraversal(root);
        System.out.print("\nInOrder Traversal: ");
        inOrderTraversal(root);
        System.out.print("\nPostOrder Traversal: ");
        postOrderTraversal(root);
    }

    public static void preOrderTraversal(TreeNode root){
        // Base Case
        if(root == null){
            return;
        }


           System.out.print(root.val + " ");


               preOrderTraversal(root.left);
               preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root){
        // Base Case
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

}
