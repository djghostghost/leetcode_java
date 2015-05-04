package org.practise.array;

/**
 * Created by liguoxiang on 5/4/15.
 */

/* problem */
/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5,
with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length
*/
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums){

        if(nums==null || nums.length==0){
            return 0;
        }

        int n=nums.length;
        if(n<3){
            return n;
        }

        Boolean flag=false;
        int start=1;
        for(int i=1;i<n;i++) {

            if (nums[i] != nums[i - 1]) {
                nums[start++] = nums[i];
                flag = false;
            } else if (nums[i] == nums[i - 1] && !flag) {
                nums[start++] = nums[i];
                flag = true;
            }

        }
        return start;
    }
}
