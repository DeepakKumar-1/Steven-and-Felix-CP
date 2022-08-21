package com.company.Trees;

public class ValidateBST2 {
    static Integer previous_val = null;
    public static boolean isBST(TreeNode root){
        if(root == null){
            return true;
        }

        // Recurse for left SubTree
        if(!isBST(root.left))
            return false;

        // Compare previous_val with current_val
        if(previous_val != null && previous_val >= root.val){
            return false;
        }
        //update previous_val to current_val
        previous_val = root.val;
        // Recurse for Right SubTree
        if(!isBST(root.right))
            return false;

        return true;
    }

    public static void main(String []args){
        Tree tree = new Tree();
        TreeNode root = tree.getTree();

        boolean ans = isBST(root);
        System.out.println(ans);
    }
}
