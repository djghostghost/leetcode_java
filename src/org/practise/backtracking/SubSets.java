package org.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
    public List<List<Integer>> subsetsByBit(int[] nums){

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
//leetcode 78
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        if(nums==null||nums.length==0){
            return results;
        }
        Arrays.sort(nums);
        subsetsHelper(0,nums,nums.length,new Stack<Integer>(),results);
        return results;

    }


    public void subsetsHelper(int index, int[] nums, int len, Stack<Integer> prefix, List<List<Integer>> ress){
        if(index==len){
            ress.add(new ArrayList<Integer>(prefix));
            return;
        }

        prefix.push(nums[index]);
        subsetsHelper(index+1,nums,len,prefix,ress);
        prefix.pop();
        subsetsHelper(index+1,nums,len,prefix,ress);

    }

    //leetcode 90
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results=new ArrayList<>();
        if(nums==null||nums.length==0){
            return results;
        }
        Arrays.sort(nums);
        subsetsWithDupHelper(0,nums,nums.length,new Stack<Integer>(),results);
        return results;

    }


    public void subsetsWithDupHelper(int index,int[] nums,int len,Stack<Integer> prefix,List<List<Integer>> ress){

        ress.add(new ArrayList<Integer>(prefix));

        for(int i=index;i<len;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            prefix.push(nums[i]);
            subsetsWithDupHelper(i+1,nums,len,prefix,ress);
            prefix.pop();
        }
    }

}
