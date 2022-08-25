package com.company.Trees;

public class Successor {
    public static void main(String []args){
//        Tree tree = new Tree();
//        TreeNode root = tree.getTree();
        TreeNode node = createTree();
        TreeNode ans = successor(node);
        if(ans == null){
            System.out.println("null");
        } else {
            System.out.println(ans.val);
        }
    }

    public static TreeNode createTree(){
        TreeNode node;
        TreeNode root, n1, n2, n3, n4, n5, n6, n7, n8, n9, n10;
        root = new TreeNode(0);
        n1 = new TreeNode(1);
        n2 = new TreeNode(2);
        n3 = new TreeNode(3);
        n4 = new TreeNode(4);
        n5 = new TreeNode(5);
        n6 = new TreeNode(6);
        n7 = new TreeNode(7);
        n8 = new TreeNode(8);
        n9 = new TreeNode(9);
        n10 = new TreeNode(10);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n3.left = n7;
        n3.right = n8;
        n2.left = n5;
        n2.right = n6;
        n5.left = n9;
        n5.right = n10;

        n1.parent = root;
        n2.parent = root;
        n3.parent = n1;
        n4.parent = n1;
        n7.parent = n3;
        n8.parent = n3;
        n5.parent = n2;
        n6.parent = n2;
        n9.parent = n5;
        n10.parent = n5;

        node = n10;
        return node;
    }

    public static TreeNode successor(TreeNode node){
        if(node == null){
            return node;
        }
        if(node.right != null){
            return leftMostChild(node.right);
        }
        TreeNode x = node;
        while(x != null && node != x.left){
            node = x;
            x = node.parent;
        }
        return x;
    }

    private static TreeNode leftMostChild(TreeNode node){
        if(node.left == null){
            return node;
        }
        return leftMostChild(node.left);
    }
}
