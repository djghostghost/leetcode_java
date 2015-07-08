package org.practise.BinarySearch;

/**
 * Created by liguoxiang on 7/5/15.
 */
public class BinarySearch {
/*
    Divide two integers without using multiplication, division and mod
     operator.
    If it is overflow, return MAX_INT.
*/
    public int divide(int dividend, int divisor) {
        if(divisor==0){
            return Integer.MAX_VALUE;
        }
        if(dividend==0){
            return 0;
        }
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }

        return 0;
    }


}
