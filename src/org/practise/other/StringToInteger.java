package org.practise.other;

/**
 * Author: ghost
 * Date  : 2015-09-29
 * TIME  : 17:30
 * PACKAGE:org.practise.other
 */
public class StringToInteger {
    //leetcode 8
    public int myAtoi(String str) {

        if(str==null || str.length()==0){
            return 0;
        }
        str=str.trim();

        final long MINVALUE=-(long)Integer.MIN_VALUE;

        int sign=1;
        int res=0;
        int index=0;
        if(str.charAt(index)=='+' || str.charAt(index)=='-'){
            if(str.charAt(index)=='-'){
                sign=-1;
            }

            index++;
        }


        for(;index<str.length();index++){
            char c=str.charAt(index);

            if(!Character.isDigit(c)){
                break;
            }

            int n=c-'0';

            if(sign>0 && (res>Integer.MAX_VALUE/10 ||(res==Integer.MAX_VALUE/10 && n>Integer.MAX_VALUE%10))){
                res=Integer.MAX_VALUE;
                break;
            }else if(sign<0 &&(res>MINVALUE/10||(res==MINVALUE/10 && n>MINVALUE%10))){
                res=Integer.MIN_VALUE;
                break;
            }
            res=res*10+n;
        }

        return sign>0?res:-res;

    }

    public static void main(String[] args) {
        StringToInteger sol=new StringToInteger();

        System.out.println(sol.myAtoi("-2147483647"));
    }
}
