package org.practise.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author: ghost
 * Date  : 2015-12-03
 * TIME  : 20:44
 * PACKAGE:org.practise.tree
 * leetcode 113#
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths=new ArrayList<>();
        if(root==null) {
            return paths;
        }
        pathSumHelper(root,sum,new Stack<Integer>(),paths);
        return paths;

    }
    public void pathSumHelper(TreeNode root, int sum, Stack<Integer> path, List<List<Integer>> paths){
        if(root.left==null && root.right==null && root.val==sum){
            ArrayList<Integer> res=new ArrayList<>(path);
            res.add(root.val);
            paths.add(res);
        }else  if(root.left==null && root.right==null){
            return;
        }
        path.add(root.val);
        if(root.left!=null) pathSumHelper(root.left,sum-root.val,path,paths);
        if(root.right!=null)pathSumHelper(root.right,sum-root.val,path,paths);
        path.pop();
    }
}
