package org.practise.string;


/*
Given an input string, reverse the string word by word.
For example,
Given s = "the sky is blue",
return "blue is sky the".
*/
public class ReverseString {
    public String reverseWords(String s){
        if(s==null || s.trim().length()==0){
            return s;
        }

        s=s.trim();
        s=s.replaceAll("\\s+"," ");
        System.out.println(s);
        StringBuilder strBuilder=new StringBuilder(s);
        strBuilder.reverse();
        int length=strBuilder.length();
        int start=0;
        boolean flag=true;
        for(int i=0;i<length;i++){
            if(Character.isWhitespace(strBuilder.charAt(i))){
                if(!flag) {
                    reverseWord(start, i-1, strBuilder);
                    flag=true;
                }
            }else if(i==length-1) {
                if(!flag) {
                    reverseWord(start, i, strBuilder);
                }

            }else if(flag){
                start=i;
                flag=false;
            }

        }

        return strBuilder.toString();
    }

    public void reverseWord(int start,int end,StringBuilder stringBuilder){
        for(int i=start,j=end;i<j;i++,j--){
            char temp=stringBuilder.charAt(i);
            stringBuilder.setCharAt(i,stringBuilder.charAt(j));
            stringBuilder.setCharAt(j,temp);
        }
    }

    public static void main(String[] args) {
        ReverseString reverse=new ReverseString();
        System.out.println(reverse.reverseWords("  one.   +two three?   ~four   !five- "));
    }

}
