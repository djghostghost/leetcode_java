package org.practise.string;

/**
 * Created by liguoxiang on 5/29/15.
 */

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space characters only.
For example,
Given s = "Hello World",
return 5.
*/
public class LengthOfLastWorld {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0) {
            return 0;
        }

        String[] splitedStr=s.split(" ");
        if(splitedStr==null || splitedStr.length==0){
            return 0;
        }else{
            int length=splitedStr.length;
            return splitedStr[length-1].length();
        }

    }

    public static void main(String[] args) {
        LengthOfLastWorld lengthOfLastWorld=new LengthOfLastWorld();
        System.out.println(lengthOfLastWorld.lengthOfLastWord(" "));
    }
}
