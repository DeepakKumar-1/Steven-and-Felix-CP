package com.company.Trees;

public class Tree {

    public TreeNode getTree(){
        TreeNode root = new TreeNode(3);
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(20);
        TreeNode third = new TreeNode(15);
        TreeNode fourth = new TreeNode(7);
        root.left = first;
        root.right = second;
        second.left = third;
        second.right = fourth;

        return root;
    }


    public static void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    public void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
        System.out.println(root.val);
    }

}
