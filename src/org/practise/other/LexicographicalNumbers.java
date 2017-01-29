package org.practise.other;

import java.util.*;

/**
 * Created by liguoxiang on 2017/01/21.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();

        if(n==0){
            return res;
        }

        for(int i=1;i<=n;i++){

            res.add(i);
        }


        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                String o1Str=String.valueOf(o1);
                String o2Str=String.valueOf(o2);


                int min=Math.min(o1Str.length(),o2Str.length());

                for(int i=0;i<min;i++){

                    if(o1Str.charAt(i)==o2Str.charAt(i)){
                        continue;
                    }else{
                        return o1Str.charAt(i)-o2Str.charAt(i);
                    }
                }

                return o1Str.length()-o2Str.length();
            }
        };

        PriorityQueue<Integer> queue=new PriorityQueue<>(comparator);

        Collections.sort(res,comparator);

        return res;
    }

    public List<Integer> lexicalOrderWithoutSort(int n){
        List<Integer> res=new ArrayList<>();

        if(n==0){
            return res;
        }

        for(int i=1;i<10;i++){
            lexicalOrderHelper(i,n,res);
        }

        return res;
    }

    private void lexicalOrderHelper(int currnumber ,int n,List<Integer> res){


        if(currnumber>n){
            return;
        }

        res.add(currnumber);
        for(int i=0;i<10;i++){

            int newNumber=currnumber*10+i;

            if(newNumber>n){
                return;
            }

            lexicalOrderHelper(newNumber,n,res);

        }

    }

    public static void main(String[] args) {
        LexicographicalNumbers sol=new LexicographicalNumbers();

        List<Integer> ress=sol.lexicalOrderWithoutSort(1000);
        System.out.println(ress.toString());


    }
}
