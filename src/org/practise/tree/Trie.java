package org.practise.tree;

import java.util.HashMap;

/**
 * Author: ghost
 * Date  : 2015-11-26
 * TIME  : 20:04
 * PACKAGE:org.practise.tree
 * leetcode 208
 */
class TrieNode {
    // Initialize your data structure here.
    HashMap<Character,TrieNode> childrens;
    boolean isLeaf;
    public TrieNode() {
        childrens=new HashMap<Character,TrieNode>();
        isLeaf=false;

    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {

        if(word==null|| word.length()==0){
            return;
        }

        int len=word.length();

        TrieNode p=root;
        for(int i=0;i<len;i++){
            char c=word.charAt(i);
            if(p.childrens.containsKey(c)){
                p=p.childrens.get(c);
            }else{
                TrieNode newNode=new TrieNode();
                p.childrens.put(c, newNode);
                p=newNode;
            }

            if(i==len-1){
                p.isLeaf=true;
            }
        }


    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p=root;
        if(word==null||word.length()==0){
            return false;
        }
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);

            if(!p.childrens.containsKey(c)){
                return false;
            }else{
                p=p.childrens.get(c);

            }
        }

        if(p.isLeaf){
            return true;
        }
        return false;

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p=root;
        if(prefix==null||prefix.length()==0){
            return false;
        }
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);

            if(!p.childrens.containsKey(c)){
                return false;
            }else{
                p=p.childrens.get(c);

            }
        }

        return true;
    }
}