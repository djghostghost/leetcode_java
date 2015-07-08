package org.practise.tree;

/**
 * Created by liguoxiang on 7/4/15.
 */
public class TreePractice {

    public void vistTreeByPreOder(TreeNode root){

    }

    public boolean isBalanced(TreeNode root){
        if(root==null){
            return true;
        }


        if(Math.abs(getHeight(root.right)-getHeight(root.left))>1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

    }


    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        String aa="";
        return Math.max(1+getHeight(root.left),
                        1+getHeight(root.right));
    }




}
