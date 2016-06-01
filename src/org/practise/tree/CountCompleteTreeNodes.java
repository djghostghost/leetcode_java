package org.practise.tree;

/**
 * Created by liguoxiang on 12/5/15.
 * leetcode 222
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int LHeight=0;
        int RHeight=0;
        TreeNode left=root;
        TreeNode right=root;
        for(;left!=null;LHeight++,left=left.left);
        for(;right!=null;RHeight++,right=right.right);

        return (LHeight==RHeight)?(1<<LHeight)-1:1+countNodes(root.left)+countNodes(root.right);
    }

}
