package org.practise.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.Collections;

/**
 * leetcode #39
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations=new ArrayList<>();
        if(candidates==null || candidates.length==0){
            return combinations;
        }
        Arrays.sort(candidates);
        int len=candidates.length-1;
        Stack<Integer> ress=new Stack<>();

        sumOfkNumber(target,candidates,len,ress,combinations);
        return combinations;
    }
    public void sumOfkNumber(int sum,int nums[],int n,Stack<Integer> res,List<List<Integer>> combinations){
        if(n<0||sum<=0){
            return ;
        }

        if(sum==nums[n]){


            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.addAll(res);

            temp.add(nums[n]);
            Collections.reverse(temp);
            combinations.add(temp);

        }

        res.push(nums[n]);
        int tempSum=sum-nums[n];
        if(tempSum>=nums[n]){
            sumOfkNumber(tempSum,nums,n,res,combinations);
        }else{
            sumOfkNumber(tempSum,nums,n-1,res,combinations);
        }

        res.pop();
        sumOfkNumber(sum,nums,n-1,res,combinations);

    }

    public static void main(String[] args) {
        CombinationSum com=new CombinationSum();
        int[] nums={2,3,4};
        List<List<Integer>> results=com.combinationSum(nums,7);

        for(List<Integer> result:results){
            System.out.println(result);
        }

    }


}
