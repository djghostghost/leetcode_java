package org.practise.stack;

import java.util.*;

/**
 * Created by liguoxiang on 5/31/15.
 *隣の姉様綺麗
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
  public int evalRPN(String[] tokens){
      if(tokens==null || tokens.length==0 ){
          return 0;
      }

      Stack<Integer> stack=new Stack<>();

      for(String token:tokens){

          if(token.matches("[\\+\\-\\*\\/]")){
              Integer top1=stack.pop();
              Integer top2=stack.pop();
              switch(token){
                  case "+":
                      stack.push(top1+top2);
                      break;
                  case "-":
                      stack.push(top2-top1);
                      break;

                  case "*":
                      stack.push(top1*top2);
                      break;

                  case "/":
                      stack.push((int)(top2/top1));
                      break;
              }
          }else{
              stack.push(Integer.parseInt(token));
          }

      }

    return stack.peek();
  }

    public static void main(String[] args) {
        RPN rpn=new RPN();
        String tokens[]={"3", "4", "/"};
        String tokens1[]={"4", "13", "5", "/", "+","5","*"};
        System.out.println(rpn.evalRPN(tokens));

    }

}
