package org.practise.tree;

/**
 * Author: ghost
 * Date  : 2016-03-05
 * TIME  : 12:56
 * PACKAGE:org.practise.tree
 * add leetcode 124
 */
public class BinaryTreeMaximumPathSum {
    class ResultType {
        public int singlePath;
        public int maxPath;

        public ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {

        return maxPathSumHelper(root).maxPath;
    }

    private ResultType maxPathSumHelper(TreeNode root) {

        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }


        ResultType left = maxPathSumHelper(root.left);
        ResultType right = maxPathSumHelper(root.right);

        int singlePath = Math.max(Math.max(left.singlePath, right.singlePath), 0)
                + root.val;


        int maxPath = Math.max(left.maxPath, right.maxPath);

        maxPath = Math.max(maxPath, Math.max(left.singlePath, 0) + Math.max(right.singlePath, 0) + root.val);

        return new ResultType(singlePath, maxPath);

    }
}
