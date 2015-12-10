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

    //leetcode 287
    public int findDuplicate(int[] nums) {

        int n=nums.length;
        int entry=0;
        for (; entry < n; entry++)
            if (entry != nums[entry])
                break;


        int slow=entry;
        int fast=entry;

        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);

        slow=entry;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;

    }
    //leetcode 191
    public int hammingWeight(int n) {
        if(n==0) return 0;

        int count=0;
        while(n!=0){
            n=n&n-1;
            count++;
        }

        return count;

    }



}
