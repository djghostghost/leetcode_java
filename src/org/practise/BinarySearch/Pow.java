package org.practise.BinarySearch;

/**
 * Author: ghost
 * Date  : 2015-12-07
 * TIME  : 19:35
 * PACKAGE:org.practise.BinarySearch
 */
public class Pow {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        if(n==0) return 1;

        int sign=(n<0)?-1:1;

        n=Math.abs(n);

        double result=myPow(x,n/2);
        result*=result;
        if(n%2!=0){
            result*=x;
        }

        return (sign==-1)?1/result:result;

    }
}
