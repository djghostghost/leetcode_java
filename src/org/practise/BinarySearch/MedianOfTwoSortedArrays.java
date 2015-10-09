package org.practise.BinarySearch;

/**
 * Author: ghost
 * Date  : 2015-10-09
 * TIME  : 21:28
 * PACKAGE:org.practise.BinarySearch
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int medianOfNums1=(nums1.length-1)>>1;
        int medianOfNums2=(nums2.length-1)>>1;

        int median=medianOfNums1+medianOfNums2;
        if(nums1.length==0){
            return nums2[median];
        }else if(nums2.length==0){
            return nums1[median];
        }



    }
}
