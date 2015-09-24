package org.practise.BinarySearch;

/**
 * Created by liguoxiang on 7/5/15.
 */
public class BinarySearch {

/*
    Divide two integers without using multiplication, division and mod
     operator.
    If it is overflow, return MAX_INT.
*/
    public int divide(int dividend, int divisor) {
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        if(dividend==0){
            return 0;
        }
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }

        return 0;
    }

    //leetcode 162
    public int findPeakElement(int[] nums) {

        int len=nums.length;
        int low=0;
        int high=len-1;
        int mid=0;

        while(low<=high){

            mid=low+((high-low)>>1);
            if((mid-1<0 || nums[mid]>nums[mid-1]) && (mid+1>=len || nums[mid]>nums[mid+1])){
                 break;
            }else if((mid-1<0 || nums[mid]>nums[mid-1])){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }

        return mid;
    }

    //leetcode 153

    public int findMin(int[] nums){
        int len=nums.length;
        int low=0;
        int high=len-1;
        int mid=0;

        if(nums[low]<=nums[high]){
            return nums[low];
        }
        while(low<=high){
            mid=low+((high-low)>>1);
            if((mid-1<0 || nums[mid]<nums[mid-1]) && (mid+1>=len || nums[mid]<nums[mid+1])){
                break;
            }else if(nums[mid]>nums[high]) {
                low = mid + 1;
            }else{
                high=mid-1;
            }

        }

        return nums[mid];
    }

    //leetcode 278
    public int firstBadVersion(int n) {
        int high=n;
        int low=2;

        int mid=0;

        if(isBadVersion(1)){
            return 1;
        }

        while(low<=high){
            mid=low+((high-low)>>1);

            if(isBadVersion(mid) && !isBadVersion(mid-1)){
                break;
            }else if(isBadVersion(mid) && isBadVersion(mid-1)){
                high=mid-1;
            }else{
                low=mid+1;
            }

        }

        return mid;
    }

    public boolean isBadVersion(int version){
        if(version>=3){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        int nums[]={0,2,-2,-1};
        BinarySearch sol=new BinarySearch();

        int n=3;
        System.out.println(sol.firstBadVersion(4));

    }



}
