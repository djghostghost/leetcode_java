package org.practise.BinarySearch;

/**
 * Author: ghost
 * Date  : 2015-12-07
 * TIME  : 19:39
 * PACKAGE:org.practise.BinarySearch
 * leetcode 29
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }

        if(divisor==1) return dividend;
        if(dividend==0) return 0;

        boolean signflagDiv=(dividend>0)?true:false;
        boolean signflagDivisor=(divisor>0)?true:false;

        long dividendL=(long)dividend;
        long divisorL=(long)divisor;

        dividendL = Math.abs(dividendL);


        divisorL=Math.abs(divisorL);

        if(dividendL<divisorL) return 0;

        long xx=divisorL;
        int result=0;
        int count=0;
        while(dividendL>=divisorL){
            result+=Math.pow(2,count);
            dividendL-=xx;
            xx+=xx;
            if(dividendL<xx){
                xx=divisorL;
                count=0;
                continue;
            }

            count++;

        }
        if(signflagDiv!=signflagDivisor){
            return -result;
        }
        return result;
    }
}
