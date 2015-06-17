package org.practise.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<List<Integer>> combinationSum(int[] candidates,int target){
        if(candidates==null || candidates.length==0 || target==0){
            return null;
        }
        List<List<Integer>> results=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();

        stack.push(candidates[0]);
        int sum=candidates[0];
        int i=0;


        while(!stack.isEmpty()){

            if(sum<target){
                if(i<candidates.length) {
                    stack.push(candidates[i]);
                    sum += candidates[i];
                }else{
                    break;
                }
            }else if(sum==target){
                List<Integer> result=new ArrayList<>();
                result.addAll(stack);
                results.add(result);


                if(i==candidates.length-1){
                    break;
                }

                do{
                    sum-=stack.pop();
                }while((candidates[i+1]+sum)>target && !stack.isEmpty());

                if(stack.isEmpty()){
                    break;
                }
                i+=1;

            }else if(sum>target){
                do{
                    sum-=stack.pop();
                }while((candidates[i+1]+sum)>target);
                i++;
            }

        }

        return results;
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
