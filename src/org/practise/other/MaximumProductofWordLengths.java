package org.practise.other;

/**
 * Author: ghost
 * Date  : 2015-12-17
 * TIME  : 20:18
 * PACKAGE:org.practise.other
 * leetcode 318
 */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        if(words==null||words.length==0){
            return 0;
        }

        int len=words.length;
        int[] intMark=new int[len];
        for(int i=0;i<len;i++){
            intMark[i]=generateIntByString(words[i]);
        }

        int maxProduct=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if((intMark[i]&intMark[j])==0){
                    maxProduct=Math.max(maxProduct,words[i].length()*words[j].length());
                }

            }
        }

        return maxProduct;
    }
    private int generateIntByString(String str){
        int res=0;

        for(int i=0;i<str.length();i++){
            res|=(1<<(str.charAt(i)-'a'));
        }
        return res;
    }
}
