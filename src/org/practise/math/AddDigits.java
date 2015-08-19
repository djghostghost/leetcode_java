package org.practise.math;

/**
 * Created by ghost on 2015/8/19.
 */
public class AddDigits {
/*
    leetcode 258
    Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
    For example:
    Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/

    //abc  --> (a*100+10*b+c)-->(a+99*a+9*b+b+c)
    //(a+99*a+9*b+b+c)%9 =(a+b+c)%9
    //if (a+b+c)%9 then a+b+c=9
    public int addDigits(int num){
        if(num==0) return 0;

        int addedDigits=num%9;
        if(addedDigits==0){
            return 9;
        }else{
            return addedDigits;
        }


    }

    public static void main(String[] args) {
        AddDigits sol=new AddDigits();
        System.out.println(sol.addDigits(11));
    }
}
