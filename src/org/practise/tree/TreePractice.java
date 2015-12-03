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
    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {

            if (p != null) {
                stack.push(p);
                p = p.left;

            } else {
                p = stack.pop();
                nodes.add(p.val);
                p = p.right;
            }


        }

        return nodes;

    }

    //  leetcode 144
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> ress = new LinkedList<>();
        if (root == null) {
            return ress;
        }

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                ress.add(p.val);
                if (p.right != null) {
                    stack.push(p.right);
                }
                p = p.left;
            } else {
                p = stack.pop();
            }
        }

        return ress;

    }

    //  leetcode 145
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ress = new LinkedList<>();
        if (root == null) {
            return ress;
        }

        TreeNode lastVistedNode = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastVistedNode != peekNode.right) {
                    root = peekNode.right;
                } else {
                    ress.add(peekNode.val);
                    lastVistedNode = stack.pop();
                }
            }

        }

        return ress;


    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }


        if (Math.abs(getHeight(root.right) - getHeight(root.left)) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);

    }


    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        String aa = "";
        return Math.max(1 + getHeight(root.left),
                1 + getHeight(root.right));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return root;
        }

        TreeNode p1 = new TreeNode(Math.min(p.val, q.val));
        TreeNode q1 = new TreeNode(Math.max(p.val, q.val));

        if (p1.val == root.val || q1.val == root.val) {
            return root;
        } else if (p1.val < root.val && q1.val > root.val) {
            return root;
        } else if (p1.val < root.val && q1.val < root.val) {
            return lowestCommonAncestor(root.left, p1, q1);
        } else {
            return lowestCommonAncestor(root.right, p1, q1);
        }

    }

    //    leetcode #257
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ress = new ArrayList<>();
        if (root == null) {
            return ress;
        }

        binaryTreePathsHelper(root, "", ress);
        return ress;
    }

    public void binaryTreePathsHelper(TreeNode root, String path, List<String> ress) {
        if (root.left == null && root.right == null) {
            path += root.val;
            ress.add(path);
            return;
        }

        if (root.left != null) binaryTreePathsHelper(root.left, path + root.val + "->", ress);
        if (root.right != null) binaryTreePathsHelper(root.right, path + root.val + "->", ress);

    }

    // leetcode 129
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        List<String> paths=new ArrayList<>();
        int sum[]={0};
        sumRootToLeaf(root,"",sum);

        return sum[0];

    }


    public void sumRootToLeaf(TreeNode root,String path,int[] sum){

        if(root.right==null && root.left==null){
            path+=root.val;
            sum[0]+=Integer.parseInt(path);
            return;
        }

        if(root.left!=null) sumRootToLeaf(root.left,path+root.val,sum);
        if(root.right!=null) sumRootToLeaf(root.right,path+root.val,sum);

    }


}
