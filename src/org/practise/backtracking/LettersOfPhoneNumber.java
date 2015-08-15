package org.practise.backtracking;


import java.util.*;


public class LettersOfPhoneNumber {
    public List<String> letterCombinations(String digits) {

        List<String> letters=new ArrayList<>();
        if(digits==null || digits.length()==0){
            return letters;
        }
        HashMap<Character,Character[]> digitMappings=new HashMap<>();

        digitMappings.put('0',new Character[]{' '});
        digitMappings.put('2',new Character[]{'a','b','c'});
        digitMappings.put('3',new Character[]{'d','e','f'});
        digitMappings.put('4',new Character[]{'g','h','i'});
        digitMappings.put('5',new Character[]{'j','k','l'});
        digitMappings.put('6',new Character[]{'m','n','o'});
        digitMappings.put('7',new Character[]{'p','q','r','s'});
        digitMappings.put('8',new Character[]{'t','u','v'});
        digitMappings.put('9',new Character[]{'w','x','y','z'});



        Stack<Character> digitStack=new Stack<>();
        Stack<Integer> indexStack=new Stack<>();
        Stack<Character> letterStack=new Stack<>();

        int i=1;
        int length=digits.length();

        digitStack.push(digits.charAt(0));
        indexStack.push(0);
        letterStack.push(digitMappings.get(digits.charAt(0))[0]);

        while(!digitStack.isEmpty()){
            if(i<length){
                digitStack.push(digits.charAt(i));
                indexStack.push(0);
                letterStack.push(digitMappings.get(digits.charAt(i))[0]);
                i++;
            }else{
                letters.add(stackToString(letterStack));

                while(!digitStack.isEmpty() &&
                        (indexStack.peek()==(digitMappings.get(digitStack.peek()).length-1))){
                    digitStack.pop();
                    indexStack.pop();
                    letterStack.pop();
                    i--;
                }

                if(digitStack.isEmpty()){
                    break;
                }

                int topIndex=indexStack.pop();
                letterStack.pop();

                topIndex++;
                indexStack.push(topIndex);
                letterStack.push(digitMappings.get(digitStack.peek())[topIndex]);
            }
        }
        return letters;
    }

    public String stackToString(Stack<Character> stack){
        StringBuilder strBuilder=new StringBuilder();
        for(Character c:stack){
            strBuilder.append(c);
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        LettersOfPhoneNumber sol=new LettersOfPhoneNumber();
        List<String> letters=sol.letterCombinations("203");

        if(letters!=null){
            for(String letter:letters){
                System.out.println(letter);
            }
        }

    }

}
