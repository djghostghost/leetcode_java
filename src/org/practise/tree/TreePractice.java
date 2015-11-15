package org.practise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by liguoxiang on 7/4/15.
 */
public class TreePractice {
//leetcode 94
    public List<Integer> inorderTraversal(TreeNode root){

        ArrayList<Integer> nodes=new ArrayList<>();
        if(root==null){
            return nodes;
        }

        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while(!stack.isEmpty()||p!=null){

            if(p!=null){
                stack.push(p);
                p=p.left;

            }else{
                p=stack.pop();
                nodes.add(p.val);
                p=p.right;
            }


        }

        return nodes;

    }

//  leetcode 144
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> ress=new LinkedList<>();
        if(root==null){
            return ress;
        }

        Stack<TreeNode> stack=new Stack<>();

        TreeNode p=root;
        while(!stack.isEmpty()||p!=null){
            if(p!=null){
                ress.add(p.val);
                if(p.right!=null){
                    stack.push(p.right);
                }
                p=p.left;
            }else{
                p=stack.pop();
            }
        }

        return ress;

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
//    leetcode #257
    public List<String> binaryTreePaths(TreeNode root) {


        List<String> results=new ArrayList<>();
        if(root==null){
            results.add("");
            return results;
        }
        if(root.left==null && root.right==null){
            results.add(String.valueOf(root.val));
            return results;
        }

        if(root.left!=null){
            List<String> leftpaths=binaryTreePaths(root.left);
            for(String path:leftpaths){
                results.add(root.val+"->"+path);
            }


        }

        if(root.right!=null){
            List<String> rightpaths=binaryTreePaths(root.right);
            for(String path:rightpaths){
                results.add(root.val+"->"+path);
            }
        }
        return results;


    }

        public static void main(String[] args) {
            TreePractice sol=new TreePractice();
            int nums[]={1,2,3,5};

            TreeNode root=TreeNode.initTreeByArray(nums);

            List<Integer> nodes=sol.preorderTraversal(root);

            for(int n:nodes){
                System.out.print(n+"->");
            }
            System.out.println();



    }

}
