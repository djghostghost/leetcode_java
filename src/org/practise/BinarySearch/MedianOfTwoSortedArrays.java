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

        int median=(nums1.length+nums2.length-1)>>1;
        if(nums1==null || nums1.length==0){
            return nums2[median];
        }else if(nums2==null || nums2.length==0){
            return nums1[median];
        }
       return findKthElementSortedArrays(nums1,0,nums1.length-1,nums2,0,nums2.length-1,median); 	
       
    }
    
    
    public int findKthElementSortedArrays(int []nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
    	
    	if(k==0){
    		return Math.min(nums1[start1],nums2[start2]);
    	}
    	
    	if(start1==end1){
    		return nums2[k];
    	}
    	
    	int mid1=start1+((end1-start1)>>1);
    	int mid2=start2+((end2-start2)>>1);
    	
    	if(nums1[mid1]==nums2[mid2]){
    		return nums1[mid1];
    	}else if(nums1[mid1]<nums2[mid2]){
    		return findKthElementSortedArrays(nums1,mid1+1,end1,nums2,start2,mid2,k-(mid1-start1+1));
    	}else{
    		return findKthElementSortedArrays(nums2,start2,end2,nums1,start1,end1,k);
    	}
    }
}
