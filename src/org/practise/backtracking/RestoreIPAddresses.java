package org.practise.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: ghost
 * Date  : 2015-11-27
 * TIME  : 21:06
 * PACKAGE:org.practise.backtracking
 * leetcode 93
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        if (s == null || s.length() < 4) {
            return ips;
        }

        int len = s.length();

        dfs(0, 1, s, len, "", ips);
        return ips;
    }

    public void dfs(int begin, int count, String s, int len, String res, List<String> ips) {

        if (begin >= len || count > 4)
            return;
        if (count == 4 && len - begin > 4)
            return;

        if (count == 4) {
            String segmentStr = s.substring(begin, len);
            if (segmentStr.charAt(0) == '0' && segmentStr.length() > 1)
                return;
            int segment = Integer.parseInt(segmentStr);
            if (segment <= 255) {
                ips.add(res + segment);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (begin + i < len) {
                String subsegment = s.substring(begin, begin + i);
                if (subsegment.charAt(0) == '0' && i != 1)
                    continue;
                if (Integer.parseInt(subsegment) <= 255)
                    dfs(begin + i, count + 1, s, len, res + subsegment + ".", ips);
            }
        }
    }
}
