package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-11-08
 * TIME  : 20:44
 * PACKAGE:org.practise.array
 */
//add leetcode 73
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        if(matrix==null || matrix.length==0){
            return;
        }

        boolean row=false;
        boolean column=false;
        int m=matrix.length;
        int n=matrix[0].length;


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(matrix[i][j]==0){

                    matrix[i][0]=0;
                    matrix[0][j]=0;

                    if(i==0){
                        row=true;
                    }
                    if(j==0){
                        column=true;
                    }
                }

            }
        }


        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(row){
            for(int j=0;j<n;j++){
                matrix[0][j]=0;
            }
        }

        if(column){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
}
