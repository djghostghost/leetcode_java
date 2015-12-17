package org.practise.other;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Author: ghost
 * Date  : 2015-12-17
 * TIME  : 20:16
 * PACKAGE:org.practise.other
 * leetcode 187
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> res=new HashSet<>();
        HashSet<String> set=new HashSet<>();
        if(s==null||s.length()<10){
            return new ArrayList<>(res);
        }

        for(int i=0;i<=s.length()-10;i++){
            String subString=s.substring(i,i+10);
            if(!set.add(subString)){
                res.add(subString);
            }

        }


        return new ArrayList<>(res);
    }
}
