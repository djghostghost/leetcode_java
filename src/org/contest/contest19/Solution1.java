package org.contest.contest19;

/**
 * Created by liguoxiang on 2017/02/12.
 */
public class Solution1 {

    public String convertTo7(int num) {

        boolean minusFlag=num<0;

        num=Math.abs(num);
        StringBuilder sb=new StringBuilder();
        while(num>=7){

            sb.insert(0,num%7);
            num=num/7;

        }

        sb.insert(0,num);

        if(minusFlag){
            sb.insert(0,"-");
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Solution1 sol=new Solution1();

        System.out.println(sol.convertTo7(-70));


    }
}
