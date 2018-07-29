package org.practise.array;


import java.util.Arrays;

public class MaximumProduct {
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);


        int len = nums.length;

        if (nums[len - 1] < 0) {


            return nums[len - 1] * nums[len - 2] * nums[len - 3];
        } else {
            return Math.max(nums[0] * nums[1], nums[len - 2] * nums[len - 3]) * nums[len - 1];
        }
    }

    public static void main(String[] args) {

        MaximumProduct sol=new MaximumProduct();

        int[] arrs={-1,-2,-3,-4};

        System.out.println(sol.maximumProduct(arrs));


    }
}
