package org.practise.string;

import java.util.HashMap;

/**
 * Created by liguoxiang on 6/6/15.
 */
/*
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced
to get t.
All occurrences of a character must be replaced with another
character while preserving the order of characters. No two characters
may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true

 */


public class IsomorphicStrings {

    public boolean isIsomorphic(String s,String t){
        if(s==null && t==null){
            return true;
        }

        if(s.equals(t)){
            return true;
        }

        HashMap<Character,Character> hashMapS=new HashMap<>();
        HashMap<Character,Character> hashMapT=new HashMap<>();

        int length=s.length();

        hashMapS.put(s.charAt(0),t.charAt(0));
        hashMapT.put(t.charAt(0),s.charAt(0));
        for(int i=1;i<length;i++){

            char charS=s.charAt(i);
            char charT=t.charAt(i);

            if ((charS==s.charAt(i-1) && charT==t.charAt(i-1)) ||
                    (charS!=s.charAt(i-1) && charT!=t.charAt(i-1))) {
                hashMapS.put(charS, charT);
                hashMapT.put(charT, charS);
            }else{
                return false;
            }

        }
        for(Character keyOfS:hashMapS.keySet()){
            Character value=hashMapS.get(keyOfS);
            if(keyOfS!=hashMapT.get(value)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings sol=new IsomorphicStrings();
        System.out.println(sol.isIsomorphic("ab","ac"));
    }
}
