package com.company.Trees;

public class RemoveSubTreeWithAllZero {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode r1 = new TreeNode(0);
        TreeNode l = new TreeNode(0);
        TreeNode r2 = new TreeNode(1);

        root.right = r1;
        r1.left = l;
        r1.right = r2;

//        TreeNode newRoot = pruneTree(root);
    }
}
