package org.practise.array;

import java.util.*;

/**
 * Created by ghost on 2015/8/29.
 */
public class Sum {
//    leetcode 15#
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results=new ArrayList<>();
        if(nums==null || nums.length<3){
            return results;
        }

        Arrays.sort(nums);

        int n=nums.length;
        for(int i=0;(i<n && nums[i]<=0);i++){

            while(i>0 && i<n-2 && nums[i]==nums[i-1]){
                i++;
            }

            int j=n-1;
            int k=i+1;


            if(i>=n || nums[i]>0 )break;
            while(k<j){
                if(nums[j]+nums[k]+nums[i]>0){
                    do{
                        j--;
                    }while(j>k && nums[j]==nums[j+1]);


                }else if(nums[j]+nums[k]+nums[i]<0){

                    do{
                        k++;
                    }while(j>k && nums[k]==nums[k-1]);

                }else{
                    List<Integer> result=new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[k]);
                    result.add(nums[j]);
                    results.add(result);
                    do{
                        k++;
                    }while(k<j && nums[k]==nums[k-1]);

                    do{
                        j--;
                    }while(k<j && nums[j]==nums[j+1]);
                }

            }


        }

        return results;
    }

}
