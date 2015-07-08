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
    

    public static void main(String[] args) {
        DynamicProgramming sol=new DynamicProgramming();
        System.out.println(sol.uniquePaths(3,2));
    }

}
