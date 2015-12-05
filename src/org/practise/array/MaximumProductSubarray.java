package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-11-10
 * TIME  : 20:45
 * PACKAGE:org.practise.array
 * leetcode 152
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }


        int max=nums[0];
        int min=nums[0];
        int maxResult=nums[0];

        for(int i=1;i<nums.length;i++){
            int maxres1=max*nums[i];
            int minres1=min*nums[i];

            max=Math.max(Math.max(maxres1, minres1),nums[i]);
            min=Math.min(Math.min(maxres1, minres1), nums[i]);

            maxResult=Math.max(max, maxResult);
        }

        return maxResult;
    }

}
