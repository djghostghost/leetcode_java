package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-12-05
 * TIME  : 18:53
 * PACKAGE:org.practise.array
 * leetcode 275
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int start=0;
        int end=citations.length-1;
        int mid=0;
        while(start<end){
            mid=start+((end-start)>>1);
            if(citations[mid]>=citations.length-mid){

                end=mid;
            }else{
                start=mid+1;
            }


        }

        return Math.min(citations[start],citations.length-start);
    }
}
