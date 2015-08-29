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

    //leetcode 268
    //n=10000 n+1=10001
    //if
    public int missingNumber(int[] nums){

        if(nums==null || nums.length==0){
            return 0;
        }
        int res=0;

        for(int i=0;i<nums.length;i++){
            res^=nums[i]^i+1;
        }
        return res;

    }

    /**
     * leetcode #190
     * @param n
     * @return int
     */

    public int reverseBits(int n) {
        final int sizeOfInt=32;

        for(int i=0;i<(sizeOfInt>>1);i++){
            int j=sizeOfInt-i-1;

            if((((n>>i)&1)^((n>>j)&1))==1){
                n^=((1<<i) |(1<<j));
            }


        }

        return n;

    }

    public static void main(String[] args) {
        BitManipulation sol=new BitManipulation();
        int n=43261596;
        System.out.println(sol.reverseBits(n));
    }


}
