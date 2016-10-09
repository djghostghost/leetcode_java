package org.practise.DynamicProgramming;

/**
 * Created by liguoxiang on 2016/10/09.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        if ((word1 == null || word1.length() == 0) && (word2 == null || word2.length() == 0)) {
            return 0;
        }

        int[][] f = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            f[i][0] = i;
        }

        for (int j = 0; j <= word2.length(); j++) {
            f[0][j] = j;
        }


        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1]) + 1);

                } else {

                    f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;

                }

            }
        }

        return f[word1.length()][word2.length()];

    }


}
