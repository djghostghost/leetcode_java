package org.practise.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by liguoxiang on 7/5/15.
 */
public class MinStack {

    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> min=new Stack<>();


    public void push(int x) {
        stack.push(x);

        if(min.isEmpty()) {
            min.push(x);
        }else{
            min.push(Math.min(min.peek(),x));
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            min.pop();
            stack.pop();
        }
    }

    public int top() {


        return stack.peek();


    }

    public int getMin() {
        return min.peek();
    }

}
