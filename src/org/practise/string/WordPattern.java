package org.practise.string;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Author: ghost
 * Date  : 2015-10-06
 * TIME  : 20:12
 * PACKAGE:org.practise.string
 * @version java 1.7
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if((pattern==null && str==null) ||(pattern.length()==0&& str.length()==0)){
            return true;
        }

        String[] strs=str.split(" ");

        if(pattern.length()!=strs.length){
            return false;
        }

        java.util.Hashtable<Character,String> patternHashTable=new java.util.Hashtable<>();
        for(int i=0;i<pattern.length();i++) {
            Character ch = pattern.charAt(i);
            if (patternHashTable.containsKey(ch)) {
                if (!patternHashTable.get(ch).equals(strs[i])) {
                    return false;
                }
            } else if(patternHashTable.containsValue(strs[i])){

                return false;

            }else{
                patternHashTable.put(ch,strs[i]);
            }

        }

        return true;

    }

    public static void main(String[] args) {
        WordPattern sol=new WordPattern();
        System.out.println(sol.wordPattern("abba","dog dog dog dog"));
    }

}
