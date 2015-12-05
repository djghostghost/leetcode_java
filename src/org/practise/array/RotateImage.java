package org.practise.array;

/**
 * Author: ghost
 * Date  : 2015-11-08
 * TIME  : 20:46
 * PACKAGE:org.practise.array
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix==null|| matrix.length==1){
            return;
        }


        int n=matrix.length;
        if(n==1){
            return;
        }

        int mid=(n-1)>>1;

        for(int j=0;j<n;j++){
            rorateColumn(matrix,j,mid,n);
        }


        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(i!=j){
                    swap(matrix,i,j,j,i);
                }
            }
        }

    }

    public void rorateColumn(int[][] matrix,int column,int midOfRow,int n){
        for(int i=0;i<=midOfRow;i++){
            swap(matrix,i,column,n-1-i,column);

        }

    }

    public void swap(int[][]  matrix,int i1,int j1,int i2,int j2){

        int temp=matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=temp;

    }
}
