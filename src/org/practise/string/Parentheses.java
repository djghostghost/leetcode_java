package org.practise.string;

import java.util.*;

/**
 * Created by liguoxiang on 5/29/15.
 */
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class Parentheses {
  public boolean isValid(String s){
      if(s==null || s.length()==0){
          return true;
      }

      Stack<Character> stack=new Stack<Character>();
      HashMap<Character,Character> character=new HashMap<>();

      character.put('}','{');
      character.put(')','(');
      character.put(']','[');
      int length=s.length();

      for(int i=0;i<length;i++){
          char c=s.charAt(i);

          if(character.containsValue(c)){
            stack.push(c);
          }else if(character.containsKey(c)){
            if(!stack.isEmpty() &&stack.peek()==character.get(c)){
                stack.pop();
            }else{
                return false;
            }
          }

      }

      if(stack.empty()){
          return true;
      }else{
          return false;
      }

  }
  public List<String> generateParenthesis(int n){
      if(n==0){
          return null;
      }




      return null;
  }
    public static void main(String[] args) {
        Parentheses validParentheses=new Parentheses();
        System.out.println(validParentheses.isValid("]"));

    }

}
