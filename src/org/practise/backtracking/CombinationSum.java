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

        int i=len;
        for(;i>=0;i--){
            if(candidates[i]>target){
                continue;
            }else if(candidates[i]==target){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(candidates[i]);
                combinations.add(temp);
            }else{
                break;
            }
        }
        Stack<Integer> ress=new Stack<>();

        sumOfkNumber(target,candidates,i,ress,combinations);
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


    public void sumOfkNumber(int t,int k,int r,int target,boolean flag,boolean[] pickFlag){
        pickFlag[k]=true;//选用第K个数

        if(t+k==target){
            flag=true;

            for(int i=1;i<=k;i++){

                if(pickFlag[i]==true){
                    System.out.print(i+"->");
                }


            }
            System.out.println();
        }else {
            if (t + k + (k + 1) <= target) {
                sumOfkNumber(t + k, k + 1, r - k,target, flag, pickFlag);

            }

            if(((t+r-k)>=target) &&(t+k+1<=target)){
                pickFlag[k]=false;
                sumOfkNumber(t,k+1,r-k,target,flag,pickFlag);
            }
        }

    }

    public void search(int candidates,int target){




        boolean[] pickFlag=new boolean[candidates+1];

        boolean flag=false;
        int sum=(int)(candidates*(candidates+1)*0.5);

        sumOfkNumber(0,1,sum,target,flag,pickFlag);

    }


// leetcode 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations=new ArrayList<>();
        if(candidates==null || candidates.length==0){
            return combinations;
        }
        Arrays.sort(candidates);
        int len=candidates.length-1;

        ArrayList<Integer> nums=new ArrayList<>();
        ArrayList<Integer> counts=new ArrayList<>();

        nums.add(candidates[0]);
        counts.add(1);
        int sizeOfNums=0;
        for(int i=1;i<=len;i++){
           if(nums.get(sizeOfNums)==candidates[i]){
               counts.set(sizeOfNums,counts.get(sizeOfNums)+1);
           }else if(candidates[i]<=target){
               nums.add(candidates[i]);
               counts.add(1);
               sizeOfNums++;
           }else{
               break;
           }
        }
        Stack<Integer> ress=new Stack<>();
        sumOfkNumber(target,nums,counts,sizeOfNums,ress,combinations);
        return combinations;
    }

    public void sumOfkNumber(int sum,List<Integer> nums,List<Integer> counts,int n,Stack<Integer> res,List<List<Integer>> combinations){
        if(n<0||sum<=0){
            return ;
        }

        if(sum==nums.get(n)){


            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.addAll(res);

            temp.add(nums.get(n));
            Collections.reverse(temp);
            combinations.add(temp);

        }

        res.push(nums.get(n));
        int tempSum=sum-nums.get(n);
        if(counts.get(n)>1){
            counts.set(n,counts.get(n)-1);
            sumOfkNumber(tempSum,nums,counts,n,res,combinations);
        }else{
            counts.set(n,counts.get(n)-1);
            sumOfkNumber(tempSum,nums,counts,n-1,res,combinations);
        }

        res.pop();
        counts.set(n,counts.get(n)+1);
        sumOfkNumber(sum,nums,counts,n-1,res,combinations);

    }

    //leetcode 216
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ress=new ArrayList<>();

        if(k<=0|| n<=0 || n<k){
            return ress;
        }
        combinationSum3Helper(k,n,9,new Stack<Integer>(),ress);
        return ress;
    }

    public void combinationSum3Helper(int k,int n,int res,
                                      Stack<Integer> stack,List<List<Integer>> ress){

        if(k<0 || n<0|| res<=0)return;


        if(k==1&& n==res){
            ArrayList<Integer> list=new ArrayList<>(stack);
            list.add(res);
            Collections.reverse(list);
            ress.add(list);


        }

        stack.push(res);
        combinationSum3Helper(k-1,n-res,res-1,stack,ress);
        stack.pop();
        combinationSum3Helper(k,n,res-1,stack,ress);

    }


}
