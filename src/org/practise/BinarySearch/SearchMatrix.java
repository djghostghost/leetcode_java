package org.practise.BinarySearch;

public class SearchMatrix {
    //leetcode 240#
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0){
            return false;
        }


        int m=matrix.length;
        int n=matrix[0].length;


        for(int i=0;i<m;i++){
            if(matrix[i][0]<=target && matrix[i][n-1]>=target){
                if(isExistedInArray(matrix[i],target,n)){
                    return true;
                }
            }

        }


        return false;
    }

    public boolean isExistedInArray(int[] nums,int target,int n){

        int low=0;
        int high=n-1;
        int mid=0;
        while(low<=high){
            mid=low+((high-low)>>1);

            if(nums[mid]==target){
                return true;
            }else if(nums[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return false;

    }

    public static void main(String[] args) {
        SearchMatrix sol=new SearchMatrix();
        int matrix[][]={
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
    };

        System.out.println(sol.searchMatrix(matrix,20));
    }

}
