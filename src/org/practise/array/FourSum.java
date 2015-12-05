package org.practise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liguoxiang on 12/5/15.
 * leetcode 18
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ress=new ArrayList<>();
        if(nums==null|| nums.length<4) return ress;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            threeSum(nums,i,target-nums[i],ress);

        }

        return ress;
    }
    public void threeSum(int[] nums,int start,int target,List<List<Integer>> ress) {

        int j=0;
        int k=0;
        for(int i=start+1;i<nums.length-2;i++){
            if(i>(start+1) && nums[i]==nums[i-1]){
                continue;
            }
            j=i+1;
            k=nums.length-1;
            while(j<k){
                if(nums[j]+nums[k]+nums[i]==target){
                    List<Integer> res=new ArrayList<>();
                    res.add(nums[start]);
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    ress.add(res);
                    do{
                        j++;
                    }while(j<=k && nums[j]==nums[j-1]);
                    do{
                        k--;
                    }while(j<=k && nums[k]==nums[k+1]);

                }else if(nums[j]+nums[k]+nums[i]>target){
                    do{
                        k--;
                    }while(j<=k && nums[k]==nums[k+1]);
                }else{
                    do{
                        j++;
                    }while(j<=k && nums[j]==nums[j-1]);

                }

            }

        }

    }
}
