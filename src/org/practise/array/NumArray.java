package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-11-10
 * TIME  : 19:58
 * PACKAGE:org.practise.array
 * leetcode 303
 */
public class NumArray {

    private int[] sumress;
    public NumArray(int[] nums) {
        this.sumress=new int[nums.length+1];
        this.sumress[0]=0;

        for(int i=0;i<nums.length;i++){
            this.sumress[i+1]=nums[i]+this.sumress[i];
        }

    }

    public int sumRange(int i, int j) {



        return this.sumress[j+1]-this.sumress[i];
    }

    public static void main(String[] args) {
        int[] nums={-2,0,3,-5,2,-1};
        NumArray sol=new NumArray(nums);
        System.out.println(sol.sumRange(0,5));


    }
}
