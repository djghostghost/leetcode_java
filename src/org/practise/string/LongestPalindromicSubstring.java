package org.practise.string;

/**
 * Author: ghost
 * Date  : 2015-09-29
 * TIME  : 20:14
 * PACKAGE:org.practise.string
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        if(s==null || s.length()==0){
            return s;
        }

        StringBuilder sb=new StringBuilder(s);
        for(int i=sb.length();i>=0;i--){
            sb.insert(i,'#');
        }
        sb.insert(0,'$');
        sb.append('^');
        int len=sb.length();


        int[] p=new int[len];
        int mx=0,id=0;
        int max=0;
        int maxindex=0;
        for(int i=1;i<len-1;i++){
            p[i]=mx>i?Math.min(p[2*id-i],mx-i):1;

            while(sb.charAt(i+p[i])==sb.charAt(i-p[i])){

                p[i]++;
            }

            if(i+p[i]>mx){
                mx=i+p[i];
                id=i;
            }

            if(max<p[i]){
                maxindex=i;
                max=p[i];
            }
        }





        return s.substring((maxindex - max) / 2 , (maxindex - 1 + max) / 2);


    }

}
