package org.practise.backtracking;


import java.util.*;
import java.util.stream.Collector;

/**
 * Created by liguoxiang on 6/6/15.
 */
public class LettersOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return null;
        }

        HashMap<Character,Character[]> digitMappings=new HashMap<>();

        digitMappings.put('2',new Character[]{'a','b','c'});
        digitMappings.put('3',new Character[]{'d','e','f'});
        digitMappings.put('4',new Character[]{'g','h','i'});
        digitMappings.put('5',new Character[]{'j','k','l'});
        digitMappings.put('6',new Character[]{'m','n','o'});
        digitMappings.put('7',new Character[]{'p','q','s'});
        digitMappings.put('8',new Character[]{'t','u','v'});
        digitMappings.put('9',new Character[]{'w','x','y','z'});




        Stack<Character> digit=new Stack<>();
        Stack<Integer> index=new Stack<>();
        Stack<Character> letters=new Stack<>();

        int i=0;
        int length=digits.length();
        do {
            if(digit.size()<(length-1)) {
                char c = digits.charAt(i);
                digit.push(c);
                index.push(i);
                letters.push(digitMappings.get(c)[i]);
            }else{

                char c=digit.peek();

            }


        }while(!digit.isEmpty());






        return null;
    }


    public Boolean isLastedChar(char[] chars,int index){
        if(index==(chars.length-1)){
            return true;
        }else{
            return false;
        }

    }

}
