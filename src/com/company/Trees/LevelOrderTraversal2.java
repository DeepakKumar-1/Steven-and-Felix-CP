package com.company.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal2 {
    public static void levelOrderTraversal(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<>();

        // start with root
        queue.offer(root);
        while(!queue.isEmpty()){
            for(int i=0; i < queue.size(); i++){
                TreeNode node = queue.poll();
                System.out.print(node.val +  " ");

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
    }

    public static void main(String []args){
        Tree tree = new Tree();
        TreeNode root = tree.getTree();
        levelOrderTraversal(root);

    }
}
