package com.company.Trees;

import java.util.ArrayList;
import java.util.Random;

class TreeNodeR{
    private int val;
    public TreeNodeR left;
    public TreeNodeR right;
    private int size = 0;
    private ArrayList<TreeNodeR> list = new ArrayList<TreeNodeR>();

    public TreeNodeR(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public int size(){
        return size;
    }
    public int val(){
        return val;
    }

    public TreeNodeR getRandomNode(){
        Random random = new Random();
        int i = random.nextInt(list.size()-1);
        return list.get(i);
    }

    public void insertInOrder(int val){
        if(val >= this.val){
            if(right == null){
                this.right = new TreeNodeR(val);
                list.add(this.right);
            } else{
                right.insertInOrder(val);
            }
        } else{
            if(left == null){
                this.left = new TreeNodeR(val);
                list.add(this.left);
            } else{
                left.insertInOrder(val);
            }
        }
        size++;
    }

    // find Node in Tree
    public boolean find(int val){
        if(val == this.val){
            return true;
        }
        if(val >= this.val){
            return left != null ? left.find(val) : false;
        }
        return right != null ? right.find(val) : false;
    }

}
public class RandomNode {

}
