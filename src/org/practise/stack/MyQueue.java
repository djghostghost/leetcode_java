package org.practise.stack;

import java.util.Stack;

//Implement the following operations of a queue using stacks.
//        push(x) -- Push element x to the back of queue.
//        pop() -- Removes the element from in front of queue.
//        peek() -- Get the front element.
//        empty() -- Return whether the queue is empty.
public class MyQueue {

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> stackassgin=new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);

    }

    // Removes the element from in front of queue.
    public void pop() {
        while(stack.size()!=1){
            stackassgin.push(stack.pop());
        }
        stack.pop();
        while(!stackassgin.isEmpty()){
            stack.push(stackassgin.pop());
        }


    }

    // Get the front element.
    public int peek() {
        while(!stack.isEmpty()){
            stackassgin.push(stack.pop());
        }
        int top=stackassgin.peek();
        while(!stackassgin.isEmpty()){
            stack.push(stackassgin.pop());
        }
        return top;

    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}
