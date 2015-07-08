package org.practise.tree;

/**
 * Created by liguoxiang on 7/4/15.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        this.val=x;
    }

    TreeNode(int []nums){

    }

    public TreeNode initTreeByArray(int[] nums){
        TreeNode nodes[]=new TreeNode[nums.length];

        int i=0;
        for(int num:nums){
            if(num==-1){
                nodes[i]=null;
            }else{
                nodes[i]=new TreeNode(nums[i]);
            }
            i++;
        }

        for(int j=0;j<nodes.length;j++){
            if(nodes[j]==null){
                continue;
            }
            if(2*j+1<nodes.length && nodes[2*j+1]!=null){
                nodes[j].left=nodes[2*j+1];
            }
            if(2*j+2<nodes.length && nodes[2*j+2]!=null){
                nodes[j].right=nodes[2*j+2];
            }

        }

        return nodes[0];
    }

}
