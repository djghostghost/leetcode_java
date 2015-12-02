package org.practise.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: ghost
 * Date  : 2015-12-02
 * TIME  : 21:11
 * PACKAGE:org.practise.backtracking
 */
public class WordBreak {
    //leetcode 139
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }

        if (wordDict.contains(s)) {
            return true;
        }

        return wordBreakHelper(s, 0, wordDict,new HashSet<String>());
    }

    public boolean wordBreakHelper(String s, int index, Set<String> wordDict,Set<String> checked) {


        for (int i = index; i < s.length(); i++) {
            String substr = s.substring(index, i + 1);
            if(checked.contains(substr)) continue;
            if (wordDict.contains(substr) &&((i==s.length()-1)
                    ||(i<s.length()-1 && wordDict.contains(s.substring(i+1)))
                    || wordBreakHelper(s, i + 1, wordDict,checked))) {
                return true;
            }else{
                checked.add(substr);
            }
        }

        return false;

    }
}
