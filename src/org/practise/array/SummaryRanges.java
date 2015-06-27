package org.practise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ghost on 2015/6/27.
 */

/*
Given a sorted integer array without duplicates, return the summary of its ranges.
For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }

        int start=0;
        int runner=0;
        int len=nums.length;
        while(runner<len){
            if(runner==len-1 || nums[runner]+1!=nums[runner+1]){
                if(start!=runner){
                    result.add(nums[start]+"->"+nums[runner]);
                }else{
                    result.add(String.valueOf(nums[start]));
                }
                start=runner+1;
            }
            runner++;
        }

        return result;
    }

    public static void main(String[] args) {
        SummaryRanges sol=new SummaryRanges();
        int nums[]={1};
        for(String str:sol.summaryRanges(nums)){
            System.out.println(str);
        }

    }
}
