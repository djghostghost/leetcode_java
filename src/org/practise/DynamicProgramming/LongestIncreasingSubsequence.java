package org.practise.DynamicProgramming;

/**
 * Created by liguoxiang on 6/2/16.
 * leetcode 300
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] longestSub = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            longestSub[i] = 1;
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    longestSub[i] = longestSub[i] > longestSub[j] + 1 ? longestSub[i] : longestSub[j] + 1;
                }
            }
            max = Math.max(max, longestSub[i]);
        }

        return max;
    }
}
