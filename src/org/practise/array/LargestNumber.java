package org.practise.array;

import com.sun.tools.javac.util.ArrayUtils;
import jdk.nashorn.internal.ir.LiteralNode;

import java.util.*;
import java.util.Comparator;

/**
 * Created by liguoxiang on 6/13/15.
 */
//Given a list of non negative integers, arrange them such that they form the largest number.
//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

public class LargestNumber {
    public String largestNumber(int[] nums){
        if(nums==null || nums.length==0){
            return "0";
        }
        List<Integer> list=getList(nums);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1=o1.toString();
                String str2=o2.toString();
                return (str2+str1).compareTo(str1+str2);
            }
        });

        if(list.get(0)==0){
            return "0";
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(Integer num:list){
            stringBuilder.append(num.toString());
        }
        return stringBuilder.toString();

    }
    public ArrayList<Integer> getList(int[] nums){
        ArrayList<Integer> list=new ArrayList<>(nums.length);
        for(int num:nums){
            list.add(num);
        }
        return list;
    }

    public static void main(String[] args) {
        LargestNumber sol=new LargestNumber();
        int nums[]={3,30,34,5,9};
        System.out.println(sol.largestNumber(nums));
    }


}
