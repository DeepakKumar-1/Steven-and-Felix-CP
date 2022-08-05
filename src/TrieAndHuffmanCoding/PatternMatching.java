package com.company.TriesAndHuffmanNCoding;

class SuffixTrieNode{
    char data;
    SuffixTrieNode []children;
    boolean isTerminating;
    public SuffixTrieNode(char data){
        this.isTerminating = false;
        this.data = data;
        children = new SuffixTrieNode[26];
    }
}

public class PatternMatching {
    private SuffixTrieNode root;
    public PatternMatching(){
        root = new SuffixTrieNode('\0');
    }

    private boolean search(SuffixTrieNode root, String word){
        // Base Case
        if(word.length() == 0){
            return root.isTerminating;
        }
        int childIndex = word.charAt(0) - 'a';
        SuffixTrieNode child = root.children[childIndex];
        if(child == null){
            return false;
        }
        return search(child, word.substring(1));
    }

    public boolean search(String word){
        return search(root, word);
    }

    private void add(SuffixTrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return;
        }

        int childIndex = word.charAt(0)-'a';
        SuffixTrieNode child = root.children[childIndex];
        if(child == null){
            child = new SuffixTrieNode(word.charAt(0));
            root.children[childIndex] = child;
        }
        add(child, word.substring(1));
    }

    public void add(String word){

        while(word.length() != 0) {
            add(root, word);
            System.out.println(word);
            word = word.substring(1);
        }
    }


    public static void main(String []args){
        PatternMatching root = new PatternMatching();
        root.add("divyansh");
        System.out.println(root.search("div"));
        System.out.println(root.search("divy"));
        System.out.println(root.search("ansh"));
        System.out.println(root.search("ivy"));
        System.out.println(root.search("nsh"));
    }
}
