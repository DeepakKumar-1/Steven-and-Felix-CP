package com.company.Trees;

public class LargestDataOfNodes {

    public static int findLargestData(TreeNode root, int max){
        // Base Case
        if(root == null){
            return max;
        }
        if(root.val > max){
            max = root.val;
        }
        int leftMax = findLargestData(root.left, max);
        int rightMax = findLargestData(root.right, max);
        return Math.max(max, Math.max(leftMax, rightMax));
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

        int largest = findLargestData(root, Integer.MIN_VALUE);
        System.out.println(largest);
    }

}
