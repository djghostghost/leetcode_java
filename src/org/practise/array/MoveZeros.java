package org.practise.array;



/**
 * Created by liguoxiang on 9/19/15.
 */
//leetcode #283
public class MoveZeros {
    public void moveZeroes(int[] nums) {

        int zeroIndex=0;
        int elementIndex=0;

        for(;elementIndex<nums.length;elementIndex++){

            if(zeroIndex!=elementIndex && nums[elementIndex]!=0){
                nums[zeroIndex]=nums[elementIndex];
                zeroIndex++;
            }else if(zeroIndex==elementIndex && nums[elementIndex]!=0){
                zeroIndex++;
            }

        }


        for(;zeroIndex<nums.length;zeroIndex++){
            nums[zeroIndex]=0;
        }

    }

    public static void main(String[] args) {
        MoveZeros sol=new MoveZeros();
        int[] nums={1};
        sol.moveZeroes(nums);

        for(int num:nums){
            System.out.print(num+"->");
        }

    }

}
