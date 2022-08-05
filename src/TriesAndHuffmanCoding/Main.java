package TriesAndHuffmanCoding;

public class Main {
    public static void main(String []args){
        Trie root = new Trie();
        root.add("divyansh");
        System.out.println(root.search("divyansh"));
        System.out.println(root.search("div"));
        root.remove("divyansh");
        System.out.println(root.search("divyansh"));
    }
}
