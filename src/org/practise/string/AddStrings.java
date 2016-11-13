package org.practise.string;

/**
 * Created by liguoxiang on 2016/11/13.
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int ch1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int ch2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int res = ch1 + ch2 + carry;

            if (res >= 10) {
                carry = 1;
                res -= 10;
            } else {
                carry = 0;
            }

            sb.append(res);
            i--;
            j--;

        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
