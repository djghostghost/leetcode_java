package org.practise.math;

import java.util.Stack;

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
    //leetcode 264
    public int nthUglyNumber(int n) {
        if(n<1){
            return 0;
        }

        int[] results=new int[n];
        int id2=0,id3=0,id5=0,res=1;
        results[0]=res;
        for(int i=1;i<n;i++){


            int v2=results[id2]*2;
            int v3=results[id3]*3;
            int v5=results[id5]*5;

            res=Math.min(Math.min(v2,v3),v5);


            if(res==v2){
                id2++;
            }
            if(res==v3){
                id3++;
            }
            if(res==v5){
                id5++;
            }
            results[i]=res;

        }

        return res;

    }

        public static void main(String[] args) {
        UglyNumber sol=new UglyNumber();
        System.out.println(sol.nthUglyNumber(10));
    }
}
