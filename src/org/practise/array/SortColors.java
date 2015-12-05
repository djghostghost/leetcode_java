package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-11-08
 * TIME  : 20:42
 * PACKAGE:org.practise.array
 */
//leetcode 75
public class SortColors {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1){
            return;
        }

        int len=nums.length;
        int low=0;
        int high=len-1;

        while(nums[low]==0 && low<len-1){
            low++;
        }

        while(nums[high]==2 && high>low){
            high--;
        }

        if(low<high){
            int i=high;

            while(i>low){
                if(nums[i]==0){
                    swap(nums,i,low);
                    while(nums[low]==0 && low<len-1){
                        low++;
                    }
                }
                i--;
            }
            i=low;
            while(nums[high]==2 && high>low){
                high--;
            }
            while(i<=high){

                if(nums[i]==2){
                    swap(nums,i,high);
                    while(nums[high]==2 && high>low){
                        high--;
                    }
                }
                i++;
            }

        }

    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
