package org.practise.tree;

/**
 * Author: ghost
 * Date  : 2015-11-26
 * TIME  : 20:06
 * PACKAGE:org.practise.tree
 */
public class WordDictionary {
    Trie trie=new Trie();
    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {

        if(word==null||word.length()==0){
            return false;
        }
        return searchPattern(trie.getRoot(),word,0);

    }

    public boolean searchPattern(TrieNode root,String pattern,int counter){
        if(root==null){
            return false;
        }

        if(counter==pattern.length()) return root.isLeaf;

        char c=pattern.charAt(counter);

        if(c=='.'){
            for(Character ch:root.childrens.keySet()){
                if(searchPattern(root.childrens.get(ch),pattern,counter+1)){
                    return true;
                }
            }

        }else if(root.childrens.containsKey(c)){

            return searchPattern(root.childrens.get(c),pattern,counter+1);

        }
        return false;


    }
}
