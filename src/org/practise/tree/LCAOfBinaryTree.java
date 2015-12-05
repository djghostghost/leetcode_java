package org.practise.tree;

/**
 * Author: ghost
 * Date  : 2015-12-03
 * TIME  : 22:06
 * PACKAGE:org.practise.tree
 */
public class LCAOfBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p || root==q){
            return root;
        }

        TreeNode leftLCA=lowestCommonAncestor(root.left,p,q);
        TreeNode rightLCA=lowestCommonAncestor(root.right,p,q);

        if(rightLCA!=null && leftLCA!=null){
            return root;
        }else if(leftLCA==null){
            return rightLCA;
        }else{
            return leftLCA;
        }

    }
}
