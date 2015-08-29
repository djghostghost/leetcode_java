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
        for(int i=0;i<n;i++){
            int j=n-1;
            int k=i+1;
            int a=nums[i];
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            while(k<j){
                if(nums[j]+nums[k]+a>0){
                    j--;
                }else if(nums[j]+nums[k]+a<0){
                    k++;
                }else{
                    List<Integer> result=new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[k]);
                    result.add(nums[j]);
                    results.add(result);
                    k++;
                    j--;
                }

            }


        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums={-1,-1,0,1,2,-1,-4};
        Sum sol=new Sum();
        List<List<Integer>> results=sol.threeSum(nums);

        for(List<Integer> result:results){
            for(Integer num:result){
                System.out.print(num+"-->");
            }
            System.out.println();
        }



    }
}
