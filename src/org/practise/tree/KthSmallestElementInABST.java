package org.practise.tree;

import java.util.Stack;

/**
 * Created by liguoxiang on 2017/01/29.
 */
public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {

        Integer res=new Integer(root.val);
        Stack<TreeNode> stack=new Stack<>();

        int count=0;

        while(!stack.isEmpty() || root!=null){

            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                count++;

                if(count==k){
                    return root.val;

                }
                root=root.right;
            }

        }

        return root.val;

    }



}
