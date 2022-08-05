package com.company.Trees;

public class CountLeafNodes {

    public static int countLeafNodes(TreeNode root){
        //Base Case
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        int leftCount = countLeafNodes(root.left);
        int rightCount = countLeafNodes(root.right);
        return leftCount+rightCount;
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

        int leafNodesCount = countLeafNodes(root);
        System.out.println(leafNodesCount);
    }

}
