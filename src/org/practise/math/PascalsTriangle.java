package org.practise.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: ghost
 * Date  : 2015-12-16
 * TIME  : 20:58
 * PACKAGE:org.practise.math
 * leetcode 119
 */
public class PascalsTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>(Collections.nCopies(rowIndex+1,1));

        if(rowIndex<=1) return res;
        for(int i=2;i<=rowIndex;i++){
            for(int j=i-1;j>=i/2;j--){
                res.set(j,res.get(j)+res.get(j-1));
                //res.set(i-j,res.get(j));
            }
            for(int j=1;j<i/2;j++){
                res.set(j,res.get(i-j));
            }

        }

        return res;
    }
}
