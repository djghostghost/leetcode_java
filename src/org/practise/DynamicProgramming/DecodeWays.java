package org.practise.DynamicProgramming;

/**
 * Author: ghost
 * Date  : 2015-12-09
 * TIME  : 22:09
 * PACKAGE:org.practise.DynamicProgramming
 * leetcode 91
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s==null||s.length()==0||s.charAt(0)=='0'){
            return 0;
        }

        if(s.length()==1) return 1;
        StringBuilder sb=new StringBuilder(s);
        int len=sb.length()-1;

        int[] dp=new int[len+2];
        dp[len+1]=1;

        char ch=sb.charAt(len);
        if(ch!='0') dp[len]=1;

        for(int i=len-1;i>=0;i--){
            char currCh=sb.charAt(i);
            if(currCh=='0') continue;

            int num=(currCh-'0')*10+(ch-'0');

            if(num>0 && num<=26){
                dp[i]=dp[i+1]+dp[i+2];
            }else{
                dp[i]=dp[i+1];
            }
            ch=currCh;
        }


        return dp[0];
    }
}
