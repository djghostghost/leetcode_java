package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-11-10
 * TIME  : 19:52
 * PACKAGE:org.practise.array
 * leetcode 209
 *
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int start=0;
        int min=Integer.MAX_VALUE;
        int localSum=0;

        for(int i=0;i<nums.length;i++){
            localSum+=nums[i];
            while(localSum>=s){
                min=Math.min(min, i-start+1);
                localSum-=nums[start];
                start++;
            }

        }
        if(start==0 && localSum<s){
            return 0;
        }
        return min;
    }
}
