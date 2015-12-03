package org.practise.tree;

import java.util.Stack;

/**
 * Author: ghost
 * Date  : 2015-12-03
 * TIME  : 21:29
 * PACKAGE:org.practise.tree
 * leetcode 110
 */
public class FlattenBinaryTree {
    public void flatten(TreeNode root) {

        if(root==null||(root.left==null&&root.right==null)){
            return;
        }

        Stack<TreeNode> stack=new Stack<>();
        TreeNode dummyHead=new TreeNode(0);
        TreeNode p=root;
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                dummyHead.right=p;
                dummyHead.left=null;
                dummyHead=dummyHead.right;

                if(p.right!=null){
                    stack.push(p.right);
                }
                p=p.left;
            }else{
                p=stack.pop();
            }
        }

    }
}
