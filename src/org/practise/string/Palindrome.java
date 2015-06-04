package org.practise.string;

/**
 * Created by garrus on 15/06/04.
 */
public class Palindrome {
    public boolean isPalindrome(String s){

        if(s==null || s.length()==0){
            return true;
        }
        s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int length=s.length();

        for(int i=0,j=length-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome=new Palindrome();
        System.out.println(palindrome.isPalindrome("a d a a d a"));
    }
}
