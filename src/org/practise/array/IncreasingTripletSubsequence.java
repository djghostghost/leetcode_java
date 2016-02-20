package org.practise.array;

/**
 * Author: ghost
 * Date  : 2016-02-20
 * TIME  : 20:01
 * PACKAGE:org.practise.array
 * add leetcode 334
 */
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null||nums.length<3) return false;

        int l=nums[0];
        int m=Integer.MAX_VALUE;

        for(int i=1;i<nums.length;i++){
            if(nums[i]<=l){
                l=nums[i];
            }else if(nums[i]<m){
                m=nums[i];
            }else if(nums[i]>m){
                return true;
            }

        }

        return false;

    }

}
