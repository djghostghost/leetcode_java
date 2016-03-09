package org.practise.DynamicProgramming;

/**
 * Author: ghost
 * Date  : 2016-03-09
 * TIME  : 21:02
 * PACKAGE:org.practise.DynamicProgramming
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] mincuts = new int[s.length() + 1];
        boolean[][] isPalindrome = isPalindromeTable(s);

        mincuts[0] = 0;

        for (int i = 1; i <= s.length(); i++) {
            mincuts[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    mincuts[i] = Math.min(mincuts[i], mincuts[j] + 1);
                }
            }
        }
        return mincuts[s.length()] - 1;

    }

    private boolean[][] isPalindromeTable(String s) {
        boolean[][] palindromeTable = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            palindromeTable[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            palindromeTable[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                palindromeTable[start][start + length] =
                        palindromeTable[start + 1][start + length - 1] &&
                                (s.charAt(start) == s.charAt(start + length));
            }

        }
        return palindromeTable;
    }
}
