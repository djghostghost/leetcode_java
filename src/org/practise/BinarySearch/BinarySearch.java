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
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        return 0;
    }

    //leetcode 162
    public int findPeakElement(int[] nums) {

        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mid = 0;

        while (low <= high) {

            mid = low + ((high - low) >> 1);
            if ((mid - 1 < 0 || nums[mid] > nums[mid - 1]) && (mid + 1 >= len || nums[mid] > nums[mid + 1])) {
                break;
            } else if ((mid - 1 < 0 || nums[mid] > nums[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return mid;
    }

    //leetcode 153

    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        int mid = 0;

        if (nums[low] <= nums[high]) {
            return nums[low];
        }
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if ((mid - 1 < 0 || nums[mid] < nums[mid - 1]) && (mid + 1 >= len || nums[mid] < nums[mid + 1])) {
                break;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return nums[mid];
    }

    //leetcode 278
    public int firstBadVersion(int n) {
        int high = n;
        int low = 2;

        int mid = 0;

        if (isBadVersion(1)) {
            return 1;
        }

        while (low <= high) {
            mid = low + ((high - low) >> 1);

            if (isBadVersion(mid) && !isBadVersion(mid - 1)) {
                break;
            } else if (isBadVersion(mid) && isBadVersion(mid - 1)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return mid;
    }

    //leetcode 35#

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= nums[0]) {
            return 0;
        }

        int len = nums.length;

        if (target > nums[len - 1]) {
            return len;
        }

        int low = 1;
        int high = len - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);

            if (nums[mid] == target || nums[mid] > target && nums[mid - 1] < target) {
                break;
            } else if (nums[mid] < target && nums[mid - 1] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }


        }

        return mid;


    }

    public boolean isBadVersion(int version) {
        if (version >= 3) {
            return true;
        } else {
            return false;
        }
    }

    //leetcode 34#
    public int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }


        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (low <= high) {
            mid = low + ((high - low) >> 1);

            if (nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) {
                break;
            } else if (nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low <= high) {
            int end = mid;
            for (; end < nums.length; end++) {
                if (nums[end] != target) {
                    break;
                }

            }

            res[0] = mid;
            res[1] = end - 1;
        }
        return res;
    }
    //leetcode 74#
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix ==null || matrix.length==0){
            return false;
        }

        int low=0;
        int high=matrix.length-1;


        int n=matrix[0].length;

        int mid=0;

        while(low<=high){
            mid=low+((high-low)>>1);

            if(matrix[mid][0]<=target && matrix[mid][n-1] >=target){
                return isExistedInArray(matrix[mid],target,n);
            }else if(matrix[mid][0]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return false;

    }

    public boolean isExistedInArray(int[] nums,int target,int n){

        int low=0;
        int high=n-1;
        int mid=0;
        while(low<=high){
            mid=low+((high-low)>>1);

            if(nums[mid]==target){
                return true;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int nums[] = {0, 2, -2, -1};
        BinarySearch sol = new BinarySearch();

        int[][] array = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(sol.searchMatrix(array,3));
    }


}
