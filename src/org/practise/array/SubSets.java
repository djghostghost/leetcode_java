package org.practise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by garrus on 15/06/14.
 */
/*
Given a set of distinct integers, nums, return all possible subsets.
Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
*/
public class SubSets {
    public List<List<Integer>> subsets(int[] nums){

        if(nums==null || nums.length==0){
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> subSets=new ArrayList<>();
        int n=(int)Math.pow(2,nums.length);

        for(int i=0;i<n;i++){
            subSets.add(getSubSetsByN(nums,i));
        }

        return subSets;
    }

    public List<Integer> getSubSetsByN(int[] nums,int N){
        List<Integer> subSet=new ArrayList<>();

        if(N==0){
            return subSet;
        }

        for(int i=0;i<Integer.SIZE;i++){
            if((N>>i)==0){
                break;
            }
            if((N>>i & 1)==1){
                subSet.add(nums[i]);
            }
        }

        return subSet;
    }

    public static void main(String[] args) {
        SubSets subSets=new SubSets();
        int[] array={4,1,0};
        List<List<Integer>> subsets=subSets.subsets(array);

        for(List<Integer> subset:subsets){
            for(Integer element:subset){
                System.out.print(element + "->");
            }
            System.out.println();
        }

    }

}
