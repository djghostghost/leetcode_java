package org.practise.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: ghost
 * Date  : 2015-12-08
 * TIME  : 19:56
 * PACKAGE:org.practise.backtracking
 * leetcode 282
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> ress = new LinkedList<>();

        for (int i = 1; i <= num.length(); i++) {
            if (i > 1 && num.charAt(0) == '0') continue;
            addOperatorsHelper(num.substring(i), Long.parseLong(num.substring(0, i)), 0, (long) target, num.substring(0, i), ress, true);
        }
        return ress;
    }


    public void addOperatorsHelper(String numstr, Long currnum, long prev, long target, String res, List<String> ress, boolean sign) {

        long sum = sign ? prev + currnum : prev - currnum;
        if (numstr.length() == 0 && sum == target) {
            ress.add(res);
            return;
        } else if (numstr.length() == 0) {
            return;
        }


        for (int i = 1; i <= numstr.length(); i++) {
            if (i > 1 && numstr.charAt(0) == '0') continue;
            long subNum = Long.parseLong(numstr.substring(0, i));
            String newStr = numstr.substring(i);
            addOperatorsHelper(newStr, subNum, sum, target, res + "+" + subNum, ress, true);
            addOperatorsHelper(newStr, subNum, sum, target, res + "-" + subNum, ress, false);
            addOperatorsHelper(newStr, currnum * subNum, prev, target, res + "*" + subNum, ress, sign);

        }

    }
}
