package org.practise.math;

import java.util.HashMap;

/**
 * Created by ghost on 2015/8/30.
 */
public class FractionToRecurringDecimal {
    // leetcode 166
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator==0){
            return "";
        }

        boolean isNegative=(numerator>0 && denominator<0)||(numerator <0 && denominator>0);

        long numeratorL=Math.abs((long)numerator);
        long denominatorL=Math.abs((long)denominator);

        HashMap<Long,Integer> map=new HashMap<>();
        StringBuilder res=new StringBuilder();
        long quotion=numeratorL/denominatorL;
        res.append(quotion);
        numeratorL%=denominatorL;

        if(numeratorL!=0){
            res.append('.');
        }

        int quotionIndex=0;
        while(numeratorL!=0){
            numeratorL*=10;
            quotion=numeratorL/denominatorL;

            if(map.containsKey(numeratorL)){
                int firstindex=map.get(numeratorL)+1+res.indexOf(".");

                res.insert(firstindex,'(');
                res.append(')');
                break;

            }else{
                res.append(quotion);
                map.put(numeratorL,quotionIndex++);
            }

            numeratorL%=denominatorL;

        }


        if(isNegative){
            res.insert(0,"-");
        }

        return res.toString();

    }

    public static void main(String[] args) {
        int num1=30;
        int num2=60;
        FractionToRecurringDecimal sol=new FractionToRecurringDecimal();
        System.out.print(sol.fractionToDecimal(num1,num2));
    }
}
