package org.practise.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by liguoxiang on 2016/10/16.
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {

        if(nums.length==1) {
            return nums[0];
        }else if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        Arrays.sort(nums);

        return nums[nums.length-3];

    }



}
