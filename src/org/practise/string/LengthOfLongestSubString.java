package org.practise.string;

import java.util.HashMap;

/**
 * Author: ghost
 * Date  : 2015-12-11
 * TIME  : 19:44
 * PACKAGE:org.practise.string
 * leetcode 3
 */
public class LengthOfLongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        if(s.length()==1) return 1;

        int maxLength=0;
        HashMap<Character,Integer> map=new HashMap<>();

        int i=0,j=1;
        map.put(s.charAt(i),i);
        while(i<s.length()){

            if(j==s.length()){
                maxLength=Math.max(maxLength,j-i);
                break;
            }
            while(j<s.length()){


                char ch=s.charAt(j);
                if(map.containsKey(ch)){
                    int k=map.get(ch);
                    maxLength=Math.max(maxLength,j-i);
                    for(int m=i;m<=k;m++){
                        map.remove(s.charAt(m));
                    }

                    i=k+1;
                }
                map.put(ch,j);
                j++;
            }
        }


        return maxLength;
    }
}
