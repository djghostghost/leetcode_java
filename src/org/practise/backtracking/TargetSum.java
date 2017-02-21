package org.practise.backtracking;

/**
 * Created by liguoxiang on 2017/01/22.
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {


        int[] count=new int[1];
        findTargetSumWaysHelper(nums,0,S,count);
        return count[0];
    }

    private void findTargetSumWaysHelper(int[] nums,int index,int S,int[] count){

        if(index>=nums.length&&S!=0){
            return;
        }


        if(index==nums.length && S==0){
            count[0]++;
            return;
        }



        findTargetSumWaysHelper(nums,index+1,S-nums[index],count);
        findTargetSumWaysHelper(nums,index+1,S+nums[index],count);

    }

    public static void main(String[] args) {
        TargetSum sol=new TargetSum();
        int[] nums={1, 1, 1, 1, 1};
        System.out.println(sol.findTargetSumWays(nums,4));

    }


}
