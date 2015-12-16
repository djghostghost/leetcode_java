package org.practise.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ghost
 * Date  : 2015-12-16
 * TIME  : 20:56
 * PACKAGE:org.practise.backtracking
 * leetcode 60
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if(n==0||k==0){
            return "";
        }

        int[] factor=new int[n];
        factor[0]=1;
        for(int i=1;i<n;i++) {
            factor[i] = (i + 1) * factor[i - 1];

        }
        List<Integer> nums=new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(i+1);
        }
        StringBuilder res=new StringBuilder();
        getPermutation(nums,k,factor,n-1,res);
        return res.toString();

    }
    private void getPermutation(List<Integer> nums,int k,int[] factors,int index,StringBuilder res){

        if(k==1){
            for(Integer num:nums){
                res.append(num);
            }
            return;
        }
        if(k==factors[index]){
            for(int i=nums.size()-1;i>=0;i--){
                res.append(nums.get(i));
            }
            return;
        }

        int currNumIndex=(k-1)/factors[index-1];
        res.append(nums.get(currNumIndex));
        nums.remove(currNumIndex);
        getPermutation(nums,k-currNumIndex*factors[index-1],factors,index-1,res);
    }
}
