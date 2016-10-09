package org.practise.math;

/**
 * Created by liguoxiang on 2016/10/09.
 */
public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else if (n > 10) {
            n = 10;
        }

        int f[] = new int[11];
        int g[] = new int[11];
        int ans = 10;
        g[0] = 1;
        g[1] = 9;


        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * (11 - i) + g[i - 2] * (11 - i);
            g[i] = g[i - 1] * (10 - i);

            ans += (f[i] + g[i]);
        }

        return ans;
    }



}
