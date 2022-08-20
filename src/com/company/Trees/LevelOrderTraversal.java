package com.company.Trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(20);
        TreeNode third = new TreeNode(15);
        TreeNode fourth = new TreeNode(7);

        root.left = first;
        root.right = second;
        second.left = third;
        second.right = fourth;

        levelOrderTraversal(root);
    }

    public static void levelOrderTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null){
            System.out.println(result);
        }
        // start with root Node
        queue.add(root);

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<queueSize; i++){
                TreeNode node = queue.poll();
                list.add(node.val);

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        System.out.println(result);
    }

}
