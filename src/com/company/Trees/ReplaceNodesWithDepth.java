package com.company.Trees;

public class ReplaceNodesWithDepth {

    public static void replaceNodeWithDepth(TreeNode root){
        replaceNodeWithDepth(root, 0);
    }

    private static void replaceNodeWithDepth(TreeNode root, int depth) {
        if(root == null){
            return;
        }
        root.val = depth;
        replaceNodeWithDepth(root.left, depth+1);
        replaceNodeWithDepth(root.right, depth+1);
    }

    public static void preOrderTraversal(TreeNode root){
        if(root != null){
            System.out.print(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
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

        preOrderTraversal(root);
        replaceNodeWithDepth(root);
        System.out.println();
        preOrderTraversal(root);

    }

}
