package org.practise.string;

import sun.rmi.runtime.Log;

/**
 * Created by garrus on 15/06/09.
 */
public class LongCommonPrefix {
    public String longestCommonPrefix(String[] strs){
       if(strs==null || strs.length==0){
           return "";
       }

       String prefix=strs[0];

       for(int i=1;i<strs.length;i++){

           int len=strs[i].length();

           if(len==0 || prefix.length()==0){
               return "";
           }

           int minlen=len<prefix.length()?len:prefix.length();

           int j=0;
           for(;j<minlen;j++){
               if(strs[i].charAt(j)!=prefix.charAt(j)){
                   break;
               }
           }

           prefix=prefix.substring(0,j);

       }

        return prefix;
    }

    public static void main(String[] args) {
        LongCommonPrefix sol=new LongCommonPrefix();
        String inputs[]={"aaaa","","aabb"};
        System.out.println(sol.longestCommonPrefix(inputs));
    }
}
