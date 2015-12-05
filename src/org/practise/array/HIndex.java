package org.practise.array;

import java.util.Arrays;

/**
 * Created by liguoxiang on 12/5/15.
 * leetcode 274
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if(citations==null||citations.length==0) return 0;
        int bar=1;
        int res=0;

        Arrays.sort(citations);
        for(int i=citations.length-1;i>=0;i--){
            if(citations[i]<bar) {
                res = bar - 1;
                break;
            }
            bar++;

        }

        return Math.max(res,bar-1);
    }
}
