package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-11-09
 * TIME  : 20:14
 * PACKAGE:org.practise.array
 * LEETCODE 43
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        final String ZERO="0";

        if(num1.equals(ZERO)||num2.equals(ZERO)){
            return ZERO;
        }

        int len1=num1.length();
        int len2=num2.length();

        int[] num=new int[len1+len2];

        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int temp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+num[i+j+1];
                num[i+j]+=(temp/10);
                num[i+j+1]=(temp%10);
            }
        }
        StringBuilder sb=new StringBuilder();

        int i=0;
        while(num[i]==0){
            i++;
        }

        for(;i<(len1+len2);i++){
            sb.append(num[i]);
        }

        return sb.toString();
    }
}
