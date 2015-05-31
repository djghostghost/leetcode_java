package org.practise.array;

import java.util.HashMap;

/**
 * Created by liguoxiang on 5/31/15.
 */


/*
Given an array of integers and an integer k, find out
whether there there are two distinct indices i and j in
the array such that nums[i] = nums[j] and the difference between i and j is at most k.
*/
public class ContainsDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0 || k==0){
            return false;
        }

        int length=nums.length;
        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for(int i=0;i<length;i++){
            int value=nums[i];
            if(hashMap.containsKey(value)){
                if((i-hashMap.get(value)<=k)){
                    return true;
                }

            }

            hashMap.put(value,i);
        }

        return false;
    }

    public boolean containsDuplicate(int[] nums){

        if(nums==null || nums.length==0){
            return false;
        }
        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for(int num:nums){
            if(hashMap.containsKey(num)){
                return true;
            }else{
                hashMap.put(num,1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate sol=new ContainsDuplicate();
        int array[]={};
        System.out.println(sol.containsDuplicate(array));
    }

}
