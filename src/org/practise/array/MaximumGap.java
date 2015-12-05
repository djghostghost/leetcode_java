package org.practise.array;

import java.util.Arrays;

/**
 * Created by liguoxiang on 12/5/15.
 * leetcode 164
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length<2) return 0;

        int maximumGap=Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            maximumGap=Math.max(maximumGap,nums[i]-nums[i-1]);
        }
        return maximumGap;
    }
}
