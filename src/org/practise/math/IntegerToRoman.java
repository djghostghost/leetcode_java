package org.practise.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Author: ghost
 * Date  : 2015-12-14
 * TIME  : 20:12
 * PACKAGE:org.practise.math
 * leetcode 12
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        HashMap<Integer,String> roman=new HashMap<>();
        roman.put(1,"I");
        roman.put(5,"V");
        roman.put(9,"IX");
        roman.put(10,"X");
        roman.put(50,"L");
        roman.put(90,"XC");
        roman.put(100,"C");
        roman.put(500,"D");
        roman.put(900,"CM");
        roman.put(1000,"M");


        if(roman.containsKey(num)) return roman.get(num);


        String numStr=String.valueOf(num);

        int len=numStr.length();

        List<Integer> digi=new ArrayList<>();

        int weight=(int)Math.pow(10,len-1);
        String res="";
        for(int i=0;i<len;i++){
            char ch=numStr.charAt(i);
            int n=ch-'0';

            if(roman.containsKey(n*weight)){
                res+=roman.get(n*weight);
            }else {
                if (n > 5) {
                    res += roman.get(5 * weight);
                    n-=5;
                }
                if (n >= 1 & n < 4) {
                    for (int k = 0; k < n; k++) {
                        res += roman.get(weight);
                    }
                } else if (n == 4) {
                    res += (roman.get(weight) + roman.get(5 * weight));

                }
            }
            weight/=10;
        }

        return res;
    }
}
