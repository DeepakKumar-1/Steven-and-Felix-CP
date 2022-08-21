package com.company.Trees;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    public static boolean isBST(TreeNode root){
        if(root == null){
            return true;
        }

        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(root, inOrder);

        for(int i=0; i<inOrder.size()-1; i++){
            if(inOrder.get(i) > inOrder.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static void inOrderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }

        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);
    }

    public static void main(String []args){
        Tree tree = new Tree();
        TreeNode root = tree.getTree();

        boolean ans = isBST(root);
        System.out.println(ans);
    }
}
