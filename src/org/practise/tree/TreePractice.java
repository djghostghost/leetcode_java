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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return root;
        }

        TreeNode p1=new TreeNode(Math.min(p.val,q.val));
        TreeNode q1=new TreeNode(Math.max(p.val,q.val));

        if(p1.val==root.val || q1.val==root.val) {
            return root;
        }else if(p1.val<root.val && q1.val>root.val){
            return root;
        }else if(p1.val<root.val && q1.val<root.val){
            return lowestCommonAncestor(root.left,p1,q1);
        }else{
            return lowestCommonAncestor(root.right,p1,q1);
        }

    }

    public static void main(String[] args) {
        TreePractice sol=new TreePractice();
        int nums[]={2,1,3};

        TreeNode root=TreeNode.initTreeByArray(nums);

        TreeNode p=new TreeNode(3);
        TreeNode q=new TreeNode(1);

        System.out.println(sol.lowestCommonAncestor(root,p,q).val);



    }

}
