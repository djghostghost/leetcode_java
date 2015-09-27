package org.practise.BinarySearch;

//leetcode 33#
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if(nums==null || nums.length==0){
            return -1;
        }

        int len=nums.length;
        if(nums[0]<=nums[len-1]){
            return findElement(nums,target,0,len-1);
        }else {
            int minIndex = findMin(nums);

            if (target == nums[minIndex]) {
                return minIndex;
            } else if (nums[0] > target) {
                return findElement(nums, target, minIndex + 1, len - 1);
            } else {
                return findElement(nums, target, 0, minIndex - 1);
            }
        }

    }


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

        return mid;
    }

    public int findElement(int[] nums,int target,int start,int end){
        int low=start;
        int high=end;

        int mid=0;

        while(low<=high){
            mid=low+((high-low)>>1);

            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return -1;
    }




    public static void main(String[] args) {

        SearchInRotatedSortedArray sol=new SearchInRotatedSortedArray();
        int[] nums={5,6,7,0,1,2,4};

        System.out.println(sol.search(nums,10));


    }
}
