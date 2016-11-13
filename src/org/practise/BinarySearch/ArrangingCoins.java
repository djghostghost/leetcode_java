package org.practise.BinarySearch;

/**
 * Created by liguoxiang on 2016/11/13.
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n == 0 || n==1) {
            return n;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {

            if (n - sum < i) {
                return i - 1;
            }
            sum += i;
        }
        return 0;
    }
}
