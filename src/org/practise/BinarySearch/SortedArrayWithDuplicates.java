package org.practise.BinarySearch;

/**
 * Author: ghost
 * Date  : 2015-10-06
 * TIME  : 20:28
 * PACKAGE:org.practise.BinarySearch
 */
public class SortedArrayWithDuplicates {
    public int findMin(int[] nums) {

        int len=nums.length;
        if(len==1 || nums[0]<nums[len-1]){
            return nums[0];
        }


        for(int i=1;i<len;i++){
            if(nums[i]<nums[i-1]){
                return nums[i];
            }
        }

        return nums[0];

    }
    //leetcode #81
    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return false;
        }
        int len=nums.length;



        int low=0;
        int high=len-1;

        int mid=0;

        while(low<=high){
            mid=low+((high-low)>>1);

            if(nums[mid]==target){
                return true;
            }else if(nums[low]<nums[mid] || nums[mid]>nums[high]){

                if(target<nums[mid] && target>=nums[low]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }


            }else if(nums[mid]<nums[high]||nums[mid]<nums[low]){
                if(target>nums[mid]&& target<=nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }

            }else{
                high--;
            }
        }
        return false;


    }


    public static void main(String[] args) {
        int[] nums={3,3,4,5,1,1,2,2};
        SortedArrayWithDuplicates sol=new SortedArrayWithDuplicates();
        System.out.println(sol.search(nums,4));
    }


}
