package org.practise.string;

import com.sun.org.apache.xml.internal.utils.StringToStringTable;

import java.util.*;

/**
 * Created by garrus on 15/06/09.
 */
/*
Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.
*/

public class Anagrams {
    public List<String> anagrams(String[] strs){

        if(strs==null || strs.length==0){
            return null;
        }

        HashMap<String,Integer> hash=new HashMap<>();
        List<String> result=new ArrayList<>();



        for(int i=0;i<strs.length;i++){

            String hashCode=newHashCode(strs[i]);
            if(hash.containsKey(hashCode)){
                result.add(strs[i]);
                if(hash.get(hashCode)!=-1){
                    result.add(strs[hash.get(hashCode)]);
                    hash.put(hashCode,-1);
                }
            }else {
                hash.put(hashCode, i);
            }
        }

        return result;

    }

    public String newHashCode(String str){

        str=str.replaceAll("\\s","");
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }



    public static void main(String[] args) {
        Anagrams sol=new Anagrams();
        String input[]={"","",""};

        List<String> result=sol.anagrams(input);
        System.out.println("-----------------");
        System.out.println(result.size());
        for(String str:result) {
            System.out.println(str);
        }
        System.out.println("-----------------");
    }
}
