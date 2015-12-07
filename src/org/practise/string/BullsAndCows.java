package org.practise.string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Author: ghost
 * Date  : 2015-12-07
 * TIME  : 19:51
 * PACKAGE:org.practise.string
 * leetcode 299
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls=0;
        int cows=0;
        HashMap<Character,Integer> map=new HashMap<>();
        HashSet<Integer> checked=new HashSet<>();

        for(int i=0;i<secret.length();i++){
            char ch=secret.charAt(i);
            if(ch==guess.charAt(i)){
                bulls++;
                checked.add(i);
            }else{
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }else{
                    map.put(ch,1);
                }


            }

        }

        for(int i=0;i<guess.length();i++){
            if(checked.contains(i)) continue;

            char ch=guess.charAt(i);
            if(map.containsKey(ch)&&map.get(ch)!=0){
                cows++;
                map.put(ch,map.get(ch)-1);
            }


        }



        return bulls+"A"+cows+"B";

    }

}
