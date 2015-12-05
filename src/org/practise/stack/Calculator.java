package org.practise.stack;

import java.util.Stack;

/**
 * Author: ghost
 * Date  : 2015-11-26
 * TIME  : 20:12
 * PACKAGE:org.practise.stack
 * leetcode 224
 */
public class Calculator {
    public int calculate(String s) {

        if(s==null||s.trim().length()==0){
            return 0;
        }
        s=s.replaceAll("\\s+", "");

        Stack<Integer> stack=new Stack<Integer>();

        int weight=1;
        stack.push(weight);
        int result=0;
        int i=0;
        int mark=1;
        while(i<s.length()){
            char ch=s.charAt(i);
            switch(ch){

                case '+':
                    mark=1;
                    if(s.charAt(i+1)=='('){
                        stack.push(weight);
                        i+=2;
                    }else{

                        i++;
                    }
                    break;
                case '-':
                    if(s.charAt(i+1)=='('){
                        mark=1;
                        stack.push(weight);
                        weight=-1*weight;
                        i+=2;
                    }else{
                        mark=-1;
                        i++;
                    }
                    break;
                case ')':
                    i++;
                    mark=1;

                    weight=stack.pop();
                    break;

                case '(':
                    mark=1;
                    i++;
                    break;
                default:
                    int val=ch-'0';
                    while(i<s.length()-1&& Character.isDigit(s.charAt(++i))){
                        val=val*10+s.charAt(i)-'0';
                    }

                    result+=mark*weight*val;
                    if(i==s.length()-1){
                        i++;
                    }
            }

        }

        return result;

    }
}
