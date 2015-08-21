package org.practise.math;

/**
 * Created by ghost on 2015/8/19.
 */
public class BitManipulation {

    //leetcode 260
    public int[] singleNumber(int[] nums) {
        if(nums==null || nums.length==0){
            return nums;
        }

        int xor=0;

        for(int num:nums){
            xor ^=num;
        }

        //get the least significant bit of 1 in m xor n
        xor=xor &(-xor);

        int result[]=new int[2];


        for(int num:nums){

            if((xor&num)==0){
                result[0]^=num;
            }else{
                result[1]^=num;
            }
        }

        return result;
    }


}
