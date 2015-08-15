package org.practise.array;

/**
 * Created by liguoxiang on 7/16/15.
 */

//leetcode 238
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int len=nums.length;
        int product[]=new int[len];
        product[len-1]=1;

        int result[]=new int[len];

        for(int i=len-2;i>=0;i--){
            product[i]=nums[i+1]*product[i+1];
        }
        int temp=1;
        result[0]=product[0];
        for(int i=1;i<len;i++){
            temp*=nums[i-1];
            result[i]=temp*product[i];

        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf sol=new ProductOfArrayExceptSelf();
        int nums[]={2,3};
        int results[]=sol.productExceptSelf(nums);

        for(int result:results){
            System.out.println(result);
        }

    }
}
