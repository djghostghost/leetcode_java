package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-11-17
 * TIME  : 21:14
 * PACKAGE:org.practise.array
 * leetcode 304#
 */

public class NumMatrix {
    private int[][] ress;
    public NumMatrix(int[][] matrix) {
        int row=matrix.length;
        if(matrix==null || matrix.length==0){
            return;
        }
        int col=matrix[0].length;
        ress=new int[row][col];
        ress[0][0]=matrix[0][0];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                ress[i][j]=matrix[i][j];
                if(i!=0) ress[i][j]+=ress[i-1][j];
                if(j!=0) ress[i][j]+=ress[i][j-1];
                if(i!=0 && j!=0) ress[i][j]-=ress[i-1][j-1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(ress==null){
            return 0;
        }
        if(row1==0 && col1==0){
            return ress[row2][col2];
        }else if(row1==0 && col1!=0){
            return ress[row2][col2]-ress[row2][col1-1];
        }else if(col1==0 && row1!=0){

            return ress[row2][col2]-ress[row1-1][col2];
        }else{
            return ress[row2][col2]-ress[row2][col1-1]-ress[row1-1][col2]+ress[row1-1][col1-1];
        }
    }
}
