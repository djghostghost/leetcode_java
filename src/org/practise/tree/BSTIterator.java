package org.practise.tree;

import java.util.Stack;

/**
 * Author: ghost
 * Date  : 2015-11-25
 * TIME  : 22:05
 * PACKAGE:org.practise.other
 */
public class BSTIterator {
    public Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        if(root==null){
            return;
        }

        stack=new Stack<TreeNode>();

        while(root!=null){
            stack.push(root);
            root=root.left;
        }

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack!=null&&!stack.isEmpty();

    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p=stack.pop();
        int val=p.val;

        p=p.right;

        while(p!=null){
            stack.push(p);
            p=p.left;
        }
        return val;

    }
}
