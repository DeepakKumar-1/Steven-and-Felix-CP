package com.company.Trees;
// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/submissions/

public class MinimalTree {

    private static void inOrderTraversal(TreeNode root) {
        // Base Case
        if(root == null){
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val  + " ");
        inOrderTraversal(root.right);

    }

    public static TreeNode sortedArrayToBST(int []nums){
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    private static TreeNode sortedArrayToBST(int []nums, int start, int end){
        // Base Case
        if(start > end){
            return null;
        }

        // Find Mid
        int mid = start + (end - start)/2;
        // Create Root Node
        TreeNode root = new TreeNode(nums[mid]);
        // Create recursively Left Node
        root.left = sortedArrayToBST(nums, start, mid-1);
        // Create recursively Right Node
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }
    public static void main(String []args){
        int []arr = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(arr);
        inOrderTraversal(root);
    }

}
