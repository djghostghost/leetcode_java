package org.practise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ghost
 * Date  : 2015-11-08
 * TIME  : 20:45
 * PACKAGE:org.practise.array
 */
//leetcode 54
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ress = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ress;
        }

        int m = matrix.length;
        int n = matrix[0].length;


        int i = 0;
        int j = 0;

        int count = m * n;
        int horiMove = 1;
        int verMove = 1;
        int lowm=0;
        int lown=0;
        while (ress.size() != count) {
            while (j < n && j >= lown) {

                ress.add(matrix[i][j]);
                j += verMove;
            }

            i += verMove;
            j-=verMove;
            if (verMove == 1) {
                n -=  1;
            }else{
                lown+=1;
            }

            verMove *= -1;

            while (i < m && i >= lowm) {
                ress.add(matrix[i][j]);
                i += horiMove;
            }

            i-=horiMove;
            j-= horiMove;

            if(horiMove==-1){
                m-=1;
            }else{
                lowm+=1;
            }

            horiMove *= -1;


        }

        return ress;
    }
}
