package org.practise.tree;

/**
 * Author: ghost
 * Date  : 2015-12-05
 * TIME  : 18:44
 * PACKAGE:org.practise.tree
 * leetcode 98
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        if(root==null ||(root.left==null&& root.right==null)) return true;

        return isValidBST(root,null,null);

    }

    public boolean isValidBST(TreeNode root,Integer min,Integer max){

        if(root==null) return true;
        if((min!=null&& root.val<=min)||(max!=null&& root.val>=max)){
            return false;
        }


        return isValidBST(root.left,min,root.val)&&isValidBST(root.right,root.val,max);



    }

}
