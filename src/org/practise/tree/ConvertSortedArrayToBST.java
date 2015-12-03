package org.practise.tree;

/**
 * Author: ghost
 * Date  : 2015-12-03
 * TIME  : 20:46
 * PACKAGE:org.practise.tree
 * leetcode 108#
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0) return null;
        return sortedArrayToBST(nums,0,nums.length-1);

    }

    public TreeNode sortedArrayToBST(int[] nums,int start,int end){
        if(start==end){
            return new TreeNode(nums[start]);
        }else if(start>end){
            return null;
        }

        int mid=start+((end-start)>>1);
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sortedArrayToBST(nums,start,mid-1);
        root.right=sortedArrayToBST(nums,mid+1,end);

        return root;
    }
}
