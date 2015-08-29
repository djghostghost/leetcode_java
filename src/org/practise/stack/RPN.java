package org.practise.stack;

import java.util.*;

/**
 * Created by liguoxiang on 5/31/15.
 *
 *
 * /

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another expression.
Some examples:
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class RPN {
  //leetcode 150
  public int evalRPN(String[] tokens){
      if(tokens==null || tokens.length==0 ){
          return 0;
      }

      Stack<Integer> stack=new Stack<>();

      for(String token:tokens){

              switch(token){
                  case "+":
                      stack.push(stack.pop()+stack.pop());
                      break;
                  case "-":
                      stack.push(-stack.pop()+stack.pop());
                      break;

                  case "*":
                      stack.push(stack.pop()*stack.pop());
                      break;

                  case "/":
                      int n1=stack.pop();
                      int n2=stack.pop();
                      stack.push((int)(n2/n1));
                      break;

                  default:
                      stack.push(Integer.parseInt(token));

              }



      }

    return stack.peek();
  }

    public static void main(String[] args) {
        RPN rpn=new RPN();
        String tokens[]={"13", "5", "/"};
        String tokens1[]={"4", "13", "5", "/", "+"};
        System.out.println(rpn.evalRPN(tokens1));

    }

}
