package org.practise.math;

import java.awt.font.NumericShaper;

import java.util.TreeMap;

/**
 * Created by ghost on 2015/8/31.
 */
public class NumberToWords {
    //leetcode 273
    public String numberToWords(int num) {
        TreeMap<Integer,String> dict=new TreeMap<>();
        dict.put(0,"Zero");
        dict.put(1,"One");
        dict.put(2,"Two");
        dict.put(3,"Three");
        dict.put(4,"Four");
        dict.put(5,"Five");
        dict.put(6,"Six");
        dict.put(7,"Seven");
        dict.put(8,"Eight");
        dict.put(9,"Nine");
        dict.put(10,"Ten");
        dict.put(11,"Eleven");
        dict.put(12,"Twelve");
        dict.put(13,"Thirteen");
        dict.put(14,"Fourteen");
        dict.put(15,"Fifteen");
        dict.put(16,"Sixteen");
        dict.put(17,"Seventeen");
        dict.put(18,"Eighteen");
        dict.put(19,"Nineteen");
        dict.put(20,"Twenty");
        dict.put(30,"Thirty");
        dict.put(40,"Forty");
        dict.put(50,"Fifty");
        dict.put(60,"Sixty");
        dict.put(70,"Seventy");
        dict.put(80,"Eighty");
        dict.put(90,"Ninety");
        dict.put(100,"Hundred");
        dict.put(1000,"Thousand");
        dict.put(1000000,"Million");
        dict.put(1000000000, "Billion");

        if(dict.containsKey(num)){
            //return dict.get(num);

        }else{
//            while(dict.containsKey(num)){
//
//            }




        }



        for(Integer key:dict.keySet()){
            System.out.println(key);
        }




        return "0";
    }

    public static void main(String[] args) {
        NumberToWords sol=new NumberToWords();

        sol.numberToWords(3);
    }
}
