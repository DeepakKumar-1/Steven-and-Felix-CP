package com.company.Trees;

public class CheckBalanced {

    public static int height(TreeNode root){
        if(root == null){
            return -1;
        }
        return Math.max(height(root.left) , height(root.right)) + 1;
    }

    public static boolean checkBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        if(Math.abs(height(root.left) - height(root.right)) > 1){
            return false;
        }
        return checkBalanced(root.left) && checkBalanced(root.right);
    }

    public static void main(String []args){
        Tree tree = new Tree();
        TreeNode root = tree.getTree();

        boolean ans = checkBalanced(root);
        System.out.println(ans);
    }
}
