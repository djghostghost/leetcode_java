package org.practise.math;

/**
 * Created by ghost on 2015/8/21.
 */
public class UglyNumber {
//  leetcode #263
    public boolean isUgly(int num) {
        if(num==0){
            return false;
        }

        if(num==1 || num==2 || num==3 || num==5){
            return true;
        }

        if(num%2==0){
            return isUgly(num>>1);
        }else if(num%3==0){
            return isUgly(num/3);
        }else if(num%5==0){
            return isUgly(num/5);
        }else{
            return false;
        }


    }

    public static void main(String[] args) {
        UglyNumber sol=new UglyNumber();
        System.out.println(sol.isUgly(0));
    }
}
