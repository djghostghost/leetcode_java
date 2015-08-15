package org.practise.stack;

/**
 * Created by liguoxiang on 7/13/15.
 */

// leetcode #225
import java.util.*;
public class MyStack {

    private Queue<Integer> queue=new LinkedList<>();
    private Queue<Integer> queueAssign=new LinkedList<>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);

    }

    // Removes the element on top of the stack.
    public void pop() {
        queueAssign.clear();
        while(queue.size()!=1){
            queueAssign.add(queue.poll());
        }
        queue.poll();

        queue.addAll(queueAssign);

    }

    // Get the top element.
    public int top() {
        queueAssign.clear();
        while(queue.size()!=1){
            queueAssign.add(queue.poll());
        }
        int top=queue.poll();

        queue.addAll(queueAssign);
        queue.add(top);
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();

    }

    public static void main(String[] args) {
        MyStack stack=new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.empty());
    }
}




