package org.practise;

import java.io.*;
import java.text.DecimalFormat;

public class MyCode2 {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(insertComma(input));
    }


    public static String insertComma(String input){


        //may be the input number is so large that may be overflow
        String[] nums=input.split("\\.");

        StringBuilder sb=new StringBuilder();

        int count=0;
        for(int i=nums[0].length()-1;i>=0;i--){

            count++;
            sb.insert(0,nums[0].charAt(i));

            if(count%3==0){
                sb.insert(0,",");
            }
        }



        if(sb.length() >0 && sb.charAt(0) == ','){
            sb.deleteCharAt(0);
        }


        if(sb.length() > 1 && sb.charAt(0)=='-' && sb.charAt(1)==','){

            sb.deleteCharAt(1);
        }


        String result=sb.toString();
        if(nums.length > 1 && nums[1]!=null && nums[1].length()>0){
            result+="."+nums[1];
        }

        return result;
    }
}
