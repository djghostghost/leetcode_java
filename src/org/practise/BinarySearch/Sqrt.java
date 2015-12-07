package org.practise.BinarySearch;

/**
 * Author: ghost
 * Date  : 2015-12-07
 * TIME  : 19:33
 * PACKAGE:org.practise.BinarySearch
 * leetcode 69
 */
public class Sqrt {
    public int mySqrt(int x) {
        if(x<=0) return x;

        int start=1;
        int end=x;
        int mid=0;

        while(start<end){
            mid=start+((end-start)>>1);
            int temp=x/mid;
            if(mid<=temp &&(mid+1)>x/(mid+1)){
                return mid;
            }else if(mid<temp){
                start=mid+1;
            }else{
                end=mid-1;
            }

        }
        return start;

    }
}
