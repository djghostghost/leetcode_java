package org.practise.DynamicProgramming;

import java.util.Arrays;

/**
 * Created by liguoxiang on 2017/02/04.
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {

        if(nums==null||nums.length==0|| target==0){
            return 0;
        }

        Arrays.sort(nums);
        int[] dp=new int[target+1];



        for(int i=0;i<target+1;i++){


            for(int j=0;j<nums.length;j++){


                if(i<nums[j]){
                    break;
                }else if(i==nums[j]){
                    dp[i]+=1;
                }else{

                    dp[i]+=dp[i-nums[j]];
                }
            }
        }

        return dp[target];

    }

}
