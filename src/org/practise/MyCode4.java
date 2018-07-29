package org.practise;
import java.io.*;
import java.util.Arrays;

/*
原题
https://leetcode.com/problems/maximum-product-of-three-numbers/

 */

public class MyCode4 {

    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputNumber=input.split(",");

        int[] nums=new int[inputNumber.length];

        for(int i=0;i<inputNumber.length;i++){
            nums[i]=Integer.valueOf(inputNumber[i]);
        }

        System.out.println(maxThreeNumbersProduct(nums));
    }

    public static int maxThreeNumbersProduct(int[] nums){

        if(nums.length<3){
            return -1;
        }
        Arrays.sort(nums);


        int len = nums.length;

        if (nums[len - 1] < 0) {


            return nums[len - 1] * nums[len - 2] * nums[len - 3];
        } else {
            return Math.max(nums[0] * nums[1], nums[len - 2] * nums[len - 3]) * nums[len - 1];
        }
    }
}
