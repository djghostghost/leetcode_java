package org.practise.BinarySearch;

/**
 * Author: ghost
 * Date  : 2015-10-09
 * TIME  : 21:28
 * PACKAGE:org.practise.BinarySearch
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1=nums1.length;
        int len2=nums2.length;

        boolean isEven=((len1+len2)%2==0);
        int median=(nums1.length+nums2.length)>>1;

        if(isEven){
            int median1=median-1;
            return (findKthElementSortedArrays(nums1,0,nums1.length-1,nums2,0,nums2.length-1,median)+
                    findKthElementSortedArrays(nums1,0,nums1.length-1,nums2,0,nums2.length-1,median1))*0.5;
        }else{
            return findKthElementSortedArrays(nums1,0,nums1.length-1,nums2,0,nums2.length-1,median);
        }

       	
       
    }
    
    
    public int findKthElementSortedArrays(int []nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
    	

        int n1=end1-start1+1;
        int n2=end2-start2+1;

        if(n1==0){
            return nums2[start2+k];
        }

        if(n2==0){
            return nums1[start1+k];
        }


    	if(k==0){
            return Math.min(nums1[start1],nums2[start2]);
    		
    	}

        int i=n1/(n1+n2)*k;
        int j=k-1-i;
    	int mid1=Math.min(start1+i,end1);
    	int mid2=Math.min(start2+j,end2);
    	

        if(nums1[mid1]<=nums2[mid2]){
    		return findKthElementSortedArrays(nums1,mid1+1,end1,nums2,start2,mid2,k-(mid1-start1+1));
    	}else{
    		return findKthElementSortedArrays(nums1,start1,mid1,nums2,mid2+1,end2,k-(mid2-start2+1));
    	}
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays sol=new MedianOfTwoSortedArrays();
        int[] nums1={1,3,5,7,9};
        int[] nums2={2,4,6,8};

        System.out.println(sol.findMedianSortedArrays(nums1,nums2));
    }
}
