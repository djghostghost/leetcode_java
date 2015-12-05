package org.practise.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: ghost
 * Date  : 2015-11-30
 * TIME  : 22:50
 * PACKAGE:org.practise.backtracking
 * leetcode 131
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ress=new ArrayList<>();
        if(s==null || s.length()==0){
            return ress;
        }
        if(s.length()==1){
            ArrayList<String> res=new ArrayList<String>();
            res.add(s);
            ress.add(res);
            return ress;
        }

        partitionHelper(s,0,new Stack<String>(),ress);
        return ress;

    }

    public void partitionHelper(String s,int start, Stack<String> stack,List<List<String>> ress){
        if(start>s.length()) return;


        if(start==s.length()){
            ress.add(new ArrayList<String>(stack));
            return;
        }

        for(int i=start;i<s.length();i++){
            String temp=s.substring(start,i+1);
            if(isPlindrome(temp)){
                stack.push(temp);
                partitionHelper(s,i+1,stack,ress);
                stack.pop();
            }
        }
    }


    public boolean isPlindrome(String s){
        if(s.length()==1) return true;

        int len=s.length();
        for(int i=0;i<(s.length()>>1);i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;
    }
}
