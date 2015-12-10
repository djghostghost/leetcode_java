package org.practise.string;

import java.util.HashMap;

/**
 * Author: ghost
 * Date  : 2015-12-10
 * TIME  : 20:18
 * PACKAGE:org.practise.string
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {

        if(s==null||s.length()<2){
            return s;
        }


        StringBuilder sb=new StringBuilder(s);


        HashMap<Character,Integer> checked=new HashMap<>();
        int minIndex=minChar(s,checked);
        int secondIndex=Integer.MAX_VALUE;

        if(checked.isEmpty()){
            secondIndex=minIndex;
        }else {
            for (Character key : checked.keySet()) {
                secondIndex = Math.min(secondIndex, checked.get(key));
            }
        }
        char ch=s.charAt(minIndex);

        if(ch>s.charAt(secondIndex)||minIndex==secondIndex) {
            return String.valueOf(ch)+ removeDuplicateLetters(
                    s.substring(minIndex + 1).replace(String.valueOf(ch),""));
        }else{



            int minCharIndexInZone=secondIndex;
            for(int i=secondIndex-1;i>=minIndex;i--){
                if(s.charAt(minCharIndexInZone)>=s.charAt(i)&&s.charAt(i)!=ch){
                    minCharIndexInZone=i;
                }
            }

            if(minCharIndexInZone==secondIndex) {
                return String.valueOf(ch)+ removeDuplicateLetters(
                        s.substring(secondIndex).replace(String.valueOf(ch), ""));
            }else{
                char minCharInZone=s.charAt(minCharIndexInZone);
                return String.valueOf(ch)+String.valueOf(minCharInZone)+removeDuplicateLetters(
                        s.substring(minCharIndexInZone+1).replace(String.valueOf(ch), "")
                                .replace(String.valueOf(minCharInZone),""));
            }

        }

    }

    private int minChar(String sb,HashMap<Character,Integer> appeared){

        int minIndexOfChar=sb.length()-1;
        int minIndex=0;
        for(int i=sb.length()-1;i>=0;i--){
            char ch=sb.charAt(i);



            if(sb.charAt(i)<=sb.charAt(minIndexOfChar)){
                minIndexOfChar=i;
            }
            if(appeared.containsKey(ch)){
                continue;
            }else{
                if(ch>sb.charAt(minIndexOfChar)){
                    appeared.put(sb.charAt(minIndexOfChar),minIndexOfChar);
                    minIndexOfChar=i;
                }
                appeared.put(ch,i);
                minIndex=i;
            }
        }

        int min=Math.min(minIndex,minIndexOfChar);
        appeared.remove(sb.charAt(min));
        return min;

    }
}
