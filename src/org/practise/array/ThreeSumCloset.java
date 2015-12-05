package org.practise.array;

import java.util.Arrays;

/**
 * Created by liguoxiang on 12/5/15.
 * add leetcode 16
 */
public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int j=0;
        int k=0;
        int mincloset=Integer.MAX_VALUE;
        int currcloset=0;
        int currtarget=0;
        int mintarget=0;
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            j=i+1;
            k=nums.length-1;

            while(j<k){
                currtarget=nums[i]+nums[j]+nums[k];
                currcloset=Math.abs(currtarget-target);
                if(currcloset<mincloset){
                    mintarget=currtarget;
                    mincloset=currcloset;

                }

                if(currtarget<=target){
                    do{
                        j++;
                    }while(j<=k && nums[j]==nums[j-1]);
                }else{
                    do{
                        k--;
                    }while(j<=k && nums[k]==nums[k+1]);
                }

            }

        }
        return mintarget;

    }
}
