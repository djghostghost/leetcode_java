package org.practise.DynamicProgramming;

import org.practise.BinarySearch.BinarySearch;

/**
 * Created by liguoxiang on 7/5/15.
 */
public class DynamicProgramming {
//    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//    The robot can only move either down or right at any point in time. The robot is trying to reach the
// bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//    How many possible unique paths are there?
    // leetcode 62#
    public int uniquePaths(int m, int n) {
        if(m==0 || n==0){
            return 0;
        }
        int paths[][]=new int[m][n];

        paths[0][0]=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0 && j!=0) {
                    paths[i][j] = paths[i - 1][j]+paths[i][j-1];
                }

                if(j==0 || i==0 ){
                    paths[i][j]=1;
                }

            }
        }

        return paths[m-1][n-1];


    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0){
            return 0;
        }

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int[][] paths=new int[m][n];
        paths[0][0]=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    paths[i][j]=0;
                }else{
                    if(j!=0) paths[i][j]+=paths[i][j-1];
                    if(i!=0) paths[i][j]+=paths[i-1][j];
                }

            }

        }
        return paths[m-1][n-1];
    }

    //leetcode 64
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }

        int m=grid.length;
        int n=grid[0].length;


        int[][] paths=new int[m][n];
        paths[0][0]=grid[0][0];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=0 && j!=0){
                    paths[i][j]=Math.min(paths[i-1][j],paths[i][j-1])+grid[i][j];
                }else if(i==0 && j!=0){
                    paths[i][j]=paths[i][j-1]+grid[i][j];
                }else if(j==0 && i!=0){
                    paths[i][j]=paths[i-1][j]+grid[i][j];
                }


            }
        }

        return paths[m-1][n-1];

    }

//    leetcode #53
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }



        int max=nums[0];
        int currMax=nums[0];
        int len=nums.length;
        for(int i=1;i<len;i++){
            currMax=Math.max(currMax,0)+nums[i];
            max=Math.max(currMax,max);
        }

        return max;
    }

    //leetcode #279
    public int numSquares(int n){
        int num[]=new int[n+1];


        for(int i=1;i<=n;i++){

            int min=i;
            for(int j=1;j*j<=i;j++){

                min=Math.min(min,1+num[i-j*j]);
            }

            num[i]=min;


        }
        return num[n];

    }

    public static void main(String[] args) {
        DynamicProgramming sol=new DynamicProgramming();

        int nums[]={2};
        int n=12;

        System.out.println(sol.numSquares(n));


    }

}
